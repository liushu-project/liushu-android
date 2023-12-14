/*
 * Copyright (C) 2023  Elliot Xu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.elliot00.liushu.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elliot00.liushu.input.keyboard.KeyCode
import com.elliot00.liushu.service.LiushuInputMethodServiceImpl
import com.elliot00.liushu.uniffi.Candidate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class InputViewModel(
    private val ime: LiushuInputMethodServiceImpl
) : ViewModel() {
    private var _isAsciiMode = MutableStateFlow(false)
    val isAsciiMode: StateFlow<Boolean> = _isAsciiMode.asStateFlow()
    private var _capsLockState = MutableStateFlow(CapsLockState.DEACTIVATED)
    val capsLockState = _capsLockState.asStateFlow()

    private var _input = MutableStateFlow("")
    val input = _input.asStateFlow()
    private var _segmentedInputTokens = MutableStateFlow<List<String>>(emptyList())
    val formattedInputTokens: StateFlow<String> =
        _segmentedInputTokens.map { it.joinToString(separator = " ") }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ""
        )

    private var _candidates = MutableStateFlow<List<Candidate>>(emptyList())
    val candidates: StateFlow<List<Candidate>> = _candidates.asStateFlow()

    fun handleKeyClicked(keyCode: KeyCode) {
        when (keyCode) {
            is KeyCode.Alpha -> {
                handleValidAlphaKey(keyCode.code)
            }

            is KeyCode.RawText -> {
                ime.commitText(keyCode.text)
            }

            is KeyCode.AsciiModeSwitch -> {
                _isAsciiMode.update { !it }
            }

            is KeyCode.Enter -> {
                if (_input.value.isNotEmpty()) {
                    ime.commitText(_input.value)
                    _input.value = ""
                    _segmentedInputTokens.value = emptyList()
                } else {
                    ime.handleEnter()
                }
            }

            is KeyCode.Delete -> {
                if (_input.value.isNotEmpty()) {
                    _input.update { it.dropLast(1) }
                    _segmentedInputTokens.value = ime.getSegmentedInputTokens(_input.value)
                    _candidates.value = ime.search(_segmentedInputTokens.value.getOrElse(0) { "" })
                } else {
                    ime.handleDelete()
                }
            }

            is KeyCode.Shift -> {
                if (_capsLockState.value == CapsLockState.ACTIVATED || _capsLockState.value == CapsLockState.SINGLE_LETTER) {
                    _capsLockState.value = CapsLockState.DEACTIVATED
                    return
                }

                if (_input.value.isEmpty()) {
                    _capsLockState.value = CapsLockState.SINGLE_LETTER
                }
            }

            is KeyCode.Comma -> {
                ime.commitText(if (_isAsciiMode.value) "," else "，")
            }

            is KeyCode.Space -> {
                ime.commitText(" ")
            }

            is KeyCode.Period -> {
                ime.commitText(if (_isAsciiMode.value) "." else "。")
            }

            else -> {}
        }
    }

    fun handleKeyLongClicked(keyCode: KeyCode) {
        when (keyCode) {
            is KeyCode.Shift -> {
                _capsLockState.value = CapsLockState.ACTIVATED
            }

            else -> {}
        }
    }

    fun commitCandidate(candidate: Candidate) {
        _segmentedInputTokens.value = _segmentedInputTokens.value.drop(1)
        ime.commitText(candidate.text)
        if (_segmentedInputTokens.value.isEmpty()) {
            _input.value = ""
            _candidates.value = emptyList()
        } else {
            _input.value = _segmentedInputTokens.value.joinToString(separator = "")
            _candidates.value = ime.search(_segmentedInputTokens.value.getOrElse(0) { "" })
        }
    }

    private fun handleValidAlphaKey(code: String) {
        if (_isAsciiMode.value) {
            ime.commitText(code)
            return
        }

        when (_capsLockState.value) {
            CapsLockState.ACTIVATED -> {
                ime.commitText(code.uppercase())
                return
            }

            CapsLockState.SINGLE_LETTER -> {
                ime.commitText(code.uppercase())
                _capsLockState.value = CapsLockState.DEACTIVATED
                return
            }

            CapsLockState.DEACTIVATED -> {}
        }

        _input.value += code
        _segmentedInputTokens.value = ime.getSegmentedInputTokens(_input.value)
        _candidates.value = ime.search(_segmentedInputTokens.value.getOrElse(0) { "" })
    }
}

enum class CapsLockState {
    DEACTIVATED, SINGLE_LETTER, ACTIVATED
}