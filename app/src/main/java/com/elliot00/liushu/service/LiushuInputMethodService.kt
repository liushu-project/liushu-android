/*
 *     Copyright (C) 2023  Elliot Xu
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.elliot00.liushu.service

import android.text.InputType
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.elliot00.liushu.input.InputView
import com.elliot00.liushu.input.keyboard.KeyCode
import com.elliot00.liushu.service.data.CapsLockState
import com.elliot00.liushu.service.data.InputViewState
import com.elliot00.liushu.uniffi.Candidate
import com.elliot00.liushu.uniffi.Engine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import java.io.File

class LiushuInputMethodService : LifecycleInputMethodService(), SavedStateRegistryOwner {
    lateinit var engine: Engine

    private val savedStateRegistryController = SavedStateRegistryController.create(this)
    override val savedStateRegistry: SavedStateRegistry get() = savedStateRegistryController.savedStateRegistry

    override val lifecycle = dispatcher.lifecycle

    private val _state = MutableStateFlow(InputViewState())
    val state = _state.asStateFlow()

    override fun onCreate() {
        super.onCreate()
        Timber.d("InputMethodService onCreate")
        savedStateRegistryController.performRestore(null)
        val dictDir = "sunman"
        val dictFile = "sunman.trie"
        val path = sequenceOf(filesDir, dictDir, dictFile).joinToString(separator = File.separator)
        engine = Engine(path)
    }

    override fun onStartInput(attribute: EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        Timber.d("Input starting")
    }

    override fun onCreateInputView(): View {
        Timber.d("Creating input view")
        val view = InputView(this)

        window?.window?.decorView?.let { decorView ->
            decorView.setViewTreeLifecycleOwner(this)
            decorView.setViewTreeSavedStateRegistryOwner(this)
        }

        return view
    }

    fun handleKeyClicked(keyCode: KeyCode) {
        when (keyCode) {
            is KeyCode.Alpha -> {
                handleValidAlphaKey(keyCode.code)
            }

            is KeyCode.RawText -> {
                commitText(keyCode.text)
            }

            is KeyCode.AsciiModeSwitch -> {
                _state.update { it.copy(isAsciiMode = !it.isAsciiMode) }
            }

            is KeyCode.Enter -> {
                if (_state.value.input.isNotEmpty()) {
                    commitText(_state.value.input)
                } else {
                    handleEnter()
                }
            }

            is KeyCode.Delete -> {
                if (_state.value.input.isNotEmpty()) {
                    _state.update {
                        val newInput = it.input.dropLast(1)
                        val newSegmentedTokens = getSegmentedInputTokens(newInput)
                        val newCandidates = search(newInput)
                        it.copy(
                            input = newInput,
                            segmentedTokens = newSegmentedTokens,
                            candidates = newCandidates
                        )
                    }
                } else {
                    handleDelete()
                }
            }

            is KeyCode.Shift -> {
                if (_state.value.let { it.capsLockState == CapsLockState.ACTIVATED || it.capsLockState == CapsLockState.SINGLE_LETTER }) {
                    _state.update { it.copy(capsLockState = CapsLockState.DEACTIVATED) }
                    return
                }

                if (_state.value.input.isEmpty()) {
                    _state.update { it.copy(capsLockState = CapsLockState.SINGLE_LETTER) }
                }
            }

            is KeyCode.Comma -> {
                commitText(if (_state.value.isAsciiMode) "," else "，")
            }

            is KeyCode.Space -> {
                commitText(" ")
            }

            is KeyCode.Period -> {
                commitText(if (_state.value.isAsciiMode) "." else "。")
            }
        }
    }

    fun commitCandidate(candidate: Candidate) {
        commitText(candidate.text)
        _state.update {
            val newSegmentTokens = it.segmentedTokens.drop(1)
            if (newSegmentTokens.isEmpty()) {
                it.copy(input = "", candidates = emptyList(), segmentedTokens = newSegmentTokens)
            } else {
                it.copy(
                    input = newSegmentTokens.joinToString(""),
                    candidates = search(newSegmentTokens[0]),
                    segmentedTokens = newSegmentTokens
                )
            }
        }
    }

    private fun handleValidAlphaKey(code: String) {
        when (_state.value.capsLockState) {
            CapsLockState.ACTIVATED -> {
                commitText(code.uppercase())
                return
            }

            CapsLockState.SINGLE_LETTER -> {
                commitText(code.uppercase())
                _state.update { it.copy(capsLockState = CapsLockState.DEACTIVATED) }
                return
            }

            CapsLockState.DEACTIVATED -> {}
        }

        if (_state.value.isAsciiMode) {
            commitText(code)
            return
        }

        _state.update {
            val newInput = it.input + code
            val newSegmentTokens = getSegmentedInputTokens(newInput)
            val newCandidates = search(newSegmentTokens[0])
            it.copy(
                input = newInput,
                candidates = newCandidates,
                segmentedTokens = newSegmentTokens
            )
        }
    }

    override fun onFinishInput() {
        super.onFinishInput()
        Timber.d("Input finishing")
    }

    override fun onDestroy() {
        engine.close()
        super.onDestroy()
    }

    fun commitText(text: String) {
        currentInputConnection.commitText(text, 1)
    }

    fun search(code: String): List<Candidate> {
        return engine.search(code)
    }

    fun handleEnter() {
        val inputType = currentInputEditorInfo.inputType
        if ((inputType and InputType.TYPE_TEXT_FLAG_MULTI_LINE) != 0) {
            commitText("\n")
        } else {
            currentInputConnection.performEditorAction(EditorInfo.IME_ACTION_GO)
        }
    }

    fun handleDelete() {
        sendDownUpKeyEvents(KeyEvent.KEYCODE_DEL)
    }

    fun getSegmentedInputTokens(input: String): List<String> {
        return engine.segment(input)
    }
}