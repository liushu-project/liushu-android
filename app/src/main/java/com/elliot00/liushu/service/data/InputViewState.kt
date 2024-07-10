package com.elliot00.liushu.service.data

import androidx.compose.runtime.Immutable
import com.elliot00.liushu.uniffi.Candidate

@Immutable
data class InputViewState(
    val input: String = "",
    val segmentedTokens: List<String> = emptyList(),
    val isAsciiMode: Boolean = false,
    val capsLockState: CapsLockState = CapsLockState.DEACTIVATED,
    val candidates: List<Candidate> = emptyList(),
)

enum class CapsLockState {
    DEACTIVATED, SINGLE_LETTER, ACTIVATED
}