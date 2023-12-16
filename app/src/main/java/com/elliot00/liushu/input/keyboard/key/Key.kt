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

package com.elliot00.liushu.input.keyboard.key

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import kotlinx.coroutines.delay

const val TOOLTIP_DELAY_MS = 250L

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Key(
    onClick: () -> Unit,
    onLongClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    popupContent: (@Composable () -> Unit)? = null,
    longClickPopupContent: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var pressStartTime by remember { mutableLongStateOf(0L) }
    var showTooltip by remember { mutableStateOf(false) }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            pressStartTime = System.currentTimeMillis()
            showTooltip = true
        } else {
            val pressDuration = System.currentTimeMillis() - pressStartTime
            if (pressDuration < TOOLTIP_DELAY_MS) {
                val delayTime = TOOLTIP_DELAY_MS - pressDuration
                delay(delayTime)
            }
            showTooltip = false
        }
    }

    Box(
        modifier = modifier
            .fillMaxHeight()
            .combinedClickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick,
                onLongClick = onLongClick
            ), contentAlignment = Alignment.Center
    ) {
        content()
        if (popupContent != null && showTooltip) {
            KeyTooltip {
                popupContent()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BaseKey(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .combinedClickable(onClick = onClick, onLongClick = onLongClick),
        contentAlignment = Alignment.Center
    ) {
        content()
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