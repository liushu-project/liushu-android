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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.elliot00.liushu.input.data.InputMethodAction
import com.elliot00.liushu.input.data.MainInputAreaContentType
import com.elliot00.liushu.input.keyboard.key.BaseKey
import com.elliot00.liushu.input.keyboard.key.preset.BackspaceKey
import com.elliot00.liushu.input.keyboard.key.preset.EnterKey
import com.elliot00.liushu.input.keyboard.key.preset.LayoutSwitchKey
import com.elliot00.liushu.input.keyboard.key.preset.SpaceKey
import com.elliot00.liushu.input.keyboard.key.preset.SymbolKey
import com.elliot00.liushu.input.keyboard.row.KeyboardRow

@Composable
fun CommonlyUsedSymbolKeyboard(
    onMainContentTypeChange: (MainInputAreaContentType) -> Unit,
    onAction: (InputMethodAction) -> Unit
) {
    val onCommit: (String) -> Unit = { onAction(InputMethodAction.DirectlyCommit(it)) }
    Column(
        Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .padding(horizontal = 3.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        KeyboardRow {
            SymbolKey(symbol = "1", onCommit = onCommit)
            SymbolKey(symbol = "2", onCommit = onCommit)
            SymbolKey(symbol = "3", onCommit = onCommit)
            SymbolKey(symbol = "4", onCommit = onCommit)
            SymbolKey(symbol = "5", onCommit = onCommit)
            SymbolKey(symbol = "6", onCommit = onCommit)
            SymbolKey(symbol = "7", onCommit = onCommit)
            SymbolKey(symbol = "8", onCommit = onCommit)
            SymbolKey(symbol = "9", onCommit = onCommit)
            SymbolKey(symbol = "0", onCommit = onCommit)
        }
        KeyboardRow {
            Box(modifier = Modifier.weight(0.5f))
            SymbolKey(symbol = "-", onCommit = onCommit)
            SymbolKey(symbol = "/", onCommit = onCommit)
            SymbolKey(symbol = "：", onCommit = onCommit)
            SymbolKey(symbol = "；", onCommit = onCommit)
            SymbolKey(symbol = "（", onCommit = onCommit)
            SymbolKey(symbol = "）", onCommit = onCommit)
            SymbolKey(symbol = "—", onCommit = onCommit)
            SymbolKey(symbol = "“", onCommit = onCommit)
            SymbolKey(symbol = "”", onCommit = onCommit)
            Box(modifier = Modifier.weight(0.5f))
        }
        KeyboardRow {
            BaseKey(
                onClick = { onMainContentTypeChange(MainInputAreaContentType.SYMBOLS_PICKER) },
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clip(shape = MaterialTheme.shapes.medium)
                    .weight(1.5f),
            ) {
                Text(text = "=\\<")
            }
            SymbolKey(symbol = "@", onCommit = onCommit)
            SymbolKey(symbol = "…", onCommit = onCommit)
            SymbolKey(symbol = "～", onCommit = onCommit)
            SymbolKey(symbol = "、", onCommit = onCommit)
            SymbolKey(symbol = "？", onCommit = onCommit)
            SymbolKey(symbol = "！", onCommit = onCommit)
            SymbolKey(symbol = ".", onCommit = onCommit)
            BackspaceKey(onClick = { onAction(InputMethodAction.Backspace) })
        }
        KeyboardRow {
            LayoutSwitchKey(
                label = "abc",
                onClick = { onMainContentTypeChange(MainInputAreaContentType.QWERTY_KEYBOARD) })
            SymbolKey(symbol = "，︀", onCommit = onCommit)
            SpaceKey(onClick = { onAction(InputMethodAction.DirectlyCommit(" ")) }, weight = 4f)
            SymbolKey(symbol = " 。", onCommit = onCommit)
            EnterKey(onClick = { onAction(InputMethodAction.Enter) })
        }
    }
}
