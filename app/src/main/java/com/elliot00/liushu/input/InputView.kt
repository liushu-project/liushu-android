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

package com.elliot00.liushu.input

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elliot00.liushu.input.feedback.InputTokensPopup
import com.elliot00.liushu.input.keyboard.candidate.CandidateItem
import com.elliot00.liushu.service.LiushuInputMethodServiceImpl
import com.elliot00.liushu.ui.theme.LiushuTheme


class InputView(context: Context) : AbstractComposeView(context) {
    private val viewModel = InputViewModel(context as LiushuInputMethodServiceImpl)

    @Composable
    override fun Content() {
        LiushuTheme {
            InputScreen(viewModel)
        }
    }
}

@Composable
private fun InputScreen(viewModel: InputViewModel) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Surface(tonalElevation = 5.dp, modifier = Modifier.height(screenHeight / 3)) {
        val formattedInputTokens by viewModel.formattedInputTokens.collectAsStateWithLifecycle()
        InputTokensPopup(formattedInputTokens)

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val candidates by viewModel.candidates.collectAsStateWithLifecycle()
            LazyRow(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                itemsIndexed(candidates) { index, candidate ->
                    CandidateItem(
                        candidate = candidate,
                        onClick = { viewModel.commitCandidate(candidate) })
                    if (index < candidates.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight(0.6f)
                                .width(1.dp)
                        )
                    }
                }
            }
            MainInputArea(viewModel = viewModel)
        }
    }
}