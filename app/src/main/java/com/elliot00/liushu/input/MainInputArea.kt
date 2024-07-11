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

import androidx.compose.runtime.Composable
import com.elliot00.liushu.input.data.InputMethodAction
import com.elliot00.liushu.input.data.InputViewState
import com.elliot00.liushu.input.data.MainInputAreaContentType
import com.elliot00.liushu.input.keyboard.layout.preset.CommonlyUsedSymbolKeyboard
import com.elliot00.liushu.input.keyboard.layout.preset.QwertyKeyboardLayout
import com.elliot00.liushu.input.picker.EmojisPicker
import com.elliot00.liushu.input.picker.SymbolsPicker

@Composable
fun MainInputArea(
    state: InputViewState,
    onAction: (InputMethodAction) -> Unit,
) {
    val onMainContentTypeChange: (MainInputAreaContentType) -> Unit =
        { onAction(InputMethodAction.ChangeInputType(it)) }
    val onGoBack: () -> Unit =
        { onAction(InputMethodAction.ChangeInputType(MainInputAreaContentType.QWERTY_KEYBOARD)) }

    when (state.inputType) {
        MainInputAreaContentType.QWERTY_KEYBOARD -> {
            QwertyKeyboardLayout(
                onMainContentTypeChange = onMainContentTypeChange,
                state = state,
                onAction = onAction,
            )
        }

        MainInputAreaContentType.COMMONLY_USED_SYMBOLS -> {
            CommonlyUsedSymbolKeyboard(
                onMainContentTypeChange = onMainContentTypeChange,
                onAction = onAction
            )
        }

        MainInputAreaContentType.EMOJIS_PICKER -> {
            EmojisPicker(
                onPick = { onAction(InputMethodAction.DirectlyCommit(it)) },
                onGoBack = onGoBack
            )
        }

        MainInputAreaContentType.SYMBOLS_PICKER -> {
            SymbolsPicker(
                onPick = { onAction(InputMethodAction.DirectlyCommit(it)) },
                onGoBack = onGoBack
            )
        }
    }
}