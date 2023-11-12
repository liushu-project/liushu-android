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

package com.elliot00.liushu.input.keyboard.key

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowScope.Key(
    appearance: KeyDefinition.Appearance,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    showAsciiText: Boolean = false,
    showCapsLockText: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                color = appearance.backgroundColor, shape = appearance.shape
            )
            .clip(shape = appearance.shape)
            .weight(appearance.widthWeight)
            .combinedClickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
                onLongClick = onLongClick,
            ), contentAlignment = Alignment.Center
    ) {
        when (appearance.label) {
            is KeyDefinition.Appearance.Label.TextLabel -> {
                val text = when {
                    showCapsLockText -> appearance.label.textInCapsLock
                    showAsciiText -> appearance.label.textInAscii
                    else -> appearance.label.text
                }
                Text(
                    text = text,
                    style = appearance.label.style,
                    color = appearance.label.color,
                    textAlign = TextAlign.Center
                )
                if (isPressed) {
                    KeyTooltip {
                        Text(
                            text = text,
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 32.sp,
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            is KeyDefinition.Appearance.Label.IconLabel -> {
                Icon(
                    painter = painterResource(id = appearance.label.id),
                    contentDescription = appearance.label.description,
                    tint = appearance.label.color
                )
            }
        }
    }
}

@Composable
private fun KeyTooltip(content: @Composable () -> Unit) {
    Popup(offset = IntOffset(x = 0, y = -150), alignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(MaterialTheme.colorScheme.surface, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}