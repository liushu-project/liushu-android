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

package com.elliot00.liushu.input.keyboard.key.preset

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.elliot00.liushu.input.keyboard.key.Key
import com.elliot00.liushu.input.keyboard.key.VariantKeyLabel

@Composable
fun RowScope.AlphabetKey(
    label: VariantKeyLabel, isAsciiMode: Boolean, isCapsLockMode: Boolean, onClick: () -> Unit
) {
    val text = when {
        isCapsLockMode -> label.textInCapsLock
        isAsciiMode -> label.textInAscii
        else -> label.text
    }

    Key(onClick = onClick, onLongClick = null, modifier = Modifier
        .background(
            color = MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.medium
        )
        .clip(shape = MaterialTheme.shapes.medium)
        .weight(1f), popupContent = {
        Text(
            text = text,
            style = TextStyle(color = MaterialTheme.colorScheme.onSurface, fontSize = 32.sp),
            textAlign = TextAlign.Center
        )
    }) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
    }
}