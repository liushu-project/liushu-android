/*
 * Copyright (C) 2023 Elliot Xu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.elliot00.liushu.input.keyboard.layout.preset

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elliot00.liushu.input.MainInputAreaContentType
import com.elliot00.liushu.input.keyboard.KeyCode
import com.elliot00.liushu.input.keyboard.key.VariantKeyLabel
import com.elliot00.liushu.input.keyboard.key.preset.AlphabetKey
import com.elliot00.liushu.input.keyboard.key.preset.BackspaceKey
import com.elliot00.liushu.input.keyboard.key.preset.EnterKey
import com.elliot00.liushu.input.keyboard.key.preset.LanguageKey
import com.elliot00.liushu.input.keyboard.key.preset.LayoutSwitchKey
import com.elliot00.liushu.input.keyboard.key.preset.PunctuationKey
import com.elliot00.liushu.input.keyboard.key.preset.ShiftKey
import com.elliot00.liushu.input.keyboard.key.preset.SpaceKey
import com.elliot00.liushu.input.keyboard.row.KeyboardRow
import com.elliot00.liushu.service.data.CapsLockState
import com.elliot00.liushu.service.data.InputViewState


@Composable
fun QwertyKeyboardLayout(
    onMainContentTypeChange: (MainInputAreaContentType) -> Unit,
    state: InputViewState,
    onKeyPressed: (KeyCode) -> Unit
) {
    Column(
        Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .padding(horizontal = 3.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val isAsciiMode = state.isAsciiMode
        val capsLockState = state.capsLockState
        val isCapsLockMode =
            capsLockState == CapsLockState.ACTIVATED || capsLockState == CapsLockState.SINGLE_LETTER

        KeyboardRow {
            AlphabetKey(label = VariantKeyLabel(text = "q", textInCapsLock = "Q"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("q")) })
            AlphabetKey(label = VariantKeyLabel(text = "w", textInCapsLock = "W"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("w")) })
            AlphabetKey(label = VariantKeyLabel(text = "e", textInCapsLock = "E"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("e")) })
            AlphabetKey(label = VariantKeyLabel(text = "r", textInCapsLock = "R"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("r")) })
            AlphabetKey(label = VariantKeyLabel(text = "t", textInCapsLock = "T"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("t")) })
            AlphabetKey(label = VariantKeyLabel(text = "y", textInCapsLock = "Y"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("y")) })
            AlphabetKey(label = VariantKeyLabel(text = "u", textInCapsLock = "U"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("u")) })
            AlphabetKey(label = VariantKeyLabel(text = "i", textInCapsLock = "I"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("i")) })
            AlphabetKey(label = VariantKeyLabel(text = "o", textInCapsLock = "O"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("o")) })
            AlphabetKey(label = VariantKeyLabel(text = "p", textInCapsLock = "P"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("p")) })
        }
        KeyboardRow {
            Box(modifier = Modifier.weight(0.5f))
            AlphabetKey(label = VariantKeyLabel(text = "a", textInCapsLock = "A"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("a")) })
            AlphabetKey(label = VariantKeyLabel(text = "s", textInCapsLock = "S"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("s")) })
            AlphabetKey(label = VariantKeyLabel(text = "d", textInCapsLock = "D"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("d")) })
            AlphabetKey(label = VariantKeyLabel(text = "f", textInCapsLock = "F"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("f")) })
            AlphabetKey(label = VariantKeyLabel(text = "g", textInCapsLock = "G"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("g")) })
            AlphabetKey(label = VariantKeyLabel(text = "h", textInCapsLock = "H"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("h")) })
            AlphabetKey(label = VariantKeyLabel(text = "j", textInCapsLock = "J"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("j")) })
            AlphabetKey(label = VariantKeyLabel(text = "k", textInCapsLock = "K"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("k")) })
            AlphabetKey(label = VariantKeyLabel(text = "l", textInCapsLock = "L"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("l")) })
            Box(modifier = Modifier.weight(0.5f))
        }
        KeyboardRow {
            ShiftKey(onClick = { onKeyPressed(KeyCode.Shift) })
            AlphabetKey(label = VariantKeyLabel(text = "z", textInCapsLock = "Z"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("z")) })
            AlphabetKey(label = VariantKeyLabel(text = "x", textInCapsLock = "X"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("x")) })
            AlphabetKey(label = VariantKeyLabel(text = "c", textInCapsLock = "C"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("c")) })
            AlphabetKey(label = VariantKeyLabel(text = "v", textInCapsLock = "V"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("v")) })
            AlphabetKey(label = VariantKeyLabel(text = "b", textInCapsLock = "B"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("b")) })
            AlphabetKey(label = VariantKeyLabel(text = "n", textInCapsLock = "N"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("n")) })
            AlphabetKey(label = VariantKeyLabel(text = "m", textInCapsLock = "M"),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Alpha("m")) })
            BackspaceKey(onClick = { onKeyPressed(KeyCode.Delete) })
        }
        KeyboardRow {
            LayoutSwitchKey(
                label = "?123",
                onClick = { onMainContentTypeChange(MainInputAreaContentType.COMMONLY_USED_SYMBOLS) })
            PunctuationKey(label = VariantKeyLabel(text = "，", textInAscii = ","),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Comma) })
            LanguageKey(onClick = { onKeyPressed(KeyCode.AsciiModeSwitch) })
            SpaceKey(onClick = { onKeyPressed(KeyCode.Space) })
            PunctuationKey(label = VariantKeyLabel(text = "。", textInAscii = "."),
                isAsciiMode = isAsciiMode,
                isCapsLockMode = isCapsLockMode,
                onClick = { onKeyPressed(KeyCode.Period) })
            EnterKey(onClick = { onKeyPressed(KeyCode.Enter) })
        }
    }
}
