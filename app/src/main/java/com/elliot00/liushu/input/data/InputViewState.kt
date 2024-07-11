package com.elliot00.liushu.input.data

import androidx.compose.runtime.Immutable
import com.elliot00.liushu.uniffi.Candidate

@Immutable
data class InputViewState(
    val input: String = "",
    val segmentedTokens: List<String> = emptyList(),
    val isAsciiMode: Boolean = false,
    val capsLockState: CapsLockState = CapsLockState.DEACTIVATED,
    val candidates: List<Candidate> = emptyList(),
    val inputType: MainInputAreaContentType = MainInputAreaContentType.QWERTY_KEYBOARD
)

enum class CapsLockState {
    DEACTIVATED, SINGLE_LETTER, ACTIVATED
}

enum class MainInputAreaContentType {
    QWERTY_KEYBOARD, COMMONLY_USED_SYMBOLS, EMOJIS_PICKER, SYMBOLS_PICKER
}