package com.elliot00.liushu.input.data

import com.elliot00.liushu.uniffi.Candidate

sealed interface InputMethodAction {
    data class CommitCandidate(val candidate: Candidate) : InputMethodAction
    data class SendComposableKey(val key: String) : InputMethodAction
    data class DirectlyCommit(val text: String) : InputMethodAction
    data class ChangeInputType(val inputType: MainInputAreaContentType) : InputMethodAction

    // TODO: extract ascii mode as a keyboard schema
    data object ToggleAsciiMode : InputMethodAction

    /* 直接處理物理鍵盤上與輸入法相關的幾個鍵，保持和物理鍵盤相同邏輯 */
    data object Backspace : InputMethodAction
    data object Enter : InputMethodAction
    data object CapsLock : InputMethodAction
    data object Shift : InputMethodAction
    data object Space : InputMethodAction
}