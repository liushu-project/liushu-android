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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.elliot00.liushu.input.InputView
import com.elliot00.liushu.uniffi.Candidate
import com.elliot00.liushu.uniffi.Engine
import timber.log.Timber
import java.io.File

interface LiushuInputMethodServiceImpl {
    fun commitText(text: String)
    fun search(code: String): List<Candidate>
    fun handleEnter()
    fun handleDelete()
    fun getSegmentedInputTokens(input: String): List<String>
}

class LiushuInputMethodService : LifecycleInputMethodService(), ViewModelStoreOwner,
    SavedStateRegistryOwner, LiushuInputMethodServiceImpl {
    lateinit var engine: Engine

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
            decorView.setViewTreeViewModelStoreOwner(this)
            decorView.setViewTreeSavedStateRegistryOwner(this)
        }

        return view
    }

    override fun onFinishInput() {
        super.onFinishInput()
        Timber.d("Input finishing")
    }

    override fun onDestroy() {
        engine.close()
        super.onDestroy()
    }

    override fun commitText(text: String) {
        currentInputConnection.commitText(text, 1)
    }

    override fun search(code: String): List<Candidate> {
        return engine.search(code)
    }

    override fun handleEnter() {
        val inputType = currentInputEditorInfo.inputType
        if ((inputType and InputType.TYPE_TEXT_FLAG_MULTI_LINE) != 0) {
            commitText("\n")
        } else {
            currentInputConnection.performEditorAction(EditorInfo.IME_ACTION_GO)
        }
    }

    override fun handleDelete() {
        sendDownUpKeyEvents(KeyEvent.KEYCODE_DEL)
    }

    override fun getSegmentedInputTokens(input: String): List<String> {
        return engine.segment(input)
    }

    override val viewModelStore: ViewModelStore
        get() = store
    override val lifecycle: Lifecycle
        get() = dispatcher.lifecycle


    //ViewModelStore Methods
    private val store = ViewModelStore()

    //SaveStateRegestry Methods

    private val savedStateRegistryController = SavedStateRegistryController.create(this)

    override val savedStateRegistry: SavedStateRegistry get() = savedStateRegistryController.savedStateRegistry
}