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

package com.elliot00.liushu.input.keyboard.layout.preset

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.elliot00.liushu.R
import com.elliot00.liushu.input.InputViewModel
import com.elliot00.liushu.input.MainInputAreaContentType
import com.elliot00.liushu.input.keyboard.KeyCode
import com.elliot00.liushu.input.keyboard.key.KeyDefinition
import com.elliot00.liushu.input.keyboard.layout.GeneralKeyboard

@Composable
fun SunmanKeyboardLayout(
    onMainContentTypeChange: (MainInputAreaContentType) -> Unit,
    viewModel: InputViewModel
) {
    val sunmanLayout = LayoutDefinition(
        keyMatrix = arrayOf(
            arrayOf(
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "q",
                                textInCapsLock = "Q",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("q")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "w",
                                textInCapsLock = "W",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("w")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "e",
                                textInCapsLock = "E",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("e")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "r",
                                textInCapsLock = "R",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("r")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "t",
                                textInCapsLock = "T",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("t")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "y",
                                textInCapsLock = "Y",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("y")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "u",
                                textInCapsLock = "U",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("u")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "i",
                                textInCapsLock = "I",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("i")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "o",
                                textInCapsLock = "O",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("o")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "p",
                                textInCapsLock = "P",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("p")
                            )
                        )
                    )
                ),
            ),
            arrayOf(
                LayoutDefinition.KeyboardItemDef.Placeholder(.5f),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "a",
                                textInCapsLock = "A",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("a")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "s",
                                textInCapsLock = "S",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("s")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "d",
                                textInCapsLock = "D",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("d")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "f",
                                textInCapsLock = "F",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("f")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "g",
                                textInCapsLock = "G",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("g")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "h",
                                textInCapsLock = "H",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("h")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "j",
                                textInCapsLock = "J",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("j")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "k",
                                textInCapsLock = "K",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("k")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "l",
                                textInCapsLock = "L",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("l")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.Placeholder(.5f)
            ),
            arrayOf(
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.IconLabel(
                                id = R.drawable.ic_capslock_none,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                description = "shift",
                            ),
                            widthWeight = 1.5f,
                            backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Shift
                            ), longClickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Shift
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "z",
                                textInCapsLock = "Z",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("z")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "x",
                                textInCapsLock = "X",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("x")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "c",
                                textInCapsLock = "C",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("c")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "v",
                                textInCapsLock = "V",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("v")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "b",
                                textInCapsLock = "B",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("b")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "n",
                                textInCapsLock = "N",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("n")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "m",
                                textInCapsLock = "M",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Alpha("m")
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.IconLabel(
                                id = R.drawable.ic_outline_backspace_24,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                description = "backspace",
                            ),
                            widthWeight = 1.5f,
                            backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Delete
                            )
                        )
                    )
                ),
            ),
            arrayOf(
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "?123",
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                style = MaterialTheme.typography.labelLarge,
                            ),
                            widthWeight = 1.5f,
                            backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                            shape = MaterialTheme.shapes.extraLarge,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.ChangeMainContent(
                                contentType = MainInputAreaContentType.SYMBOLS_PICKER
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "，",
                                textInAscii = ",",
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Comma
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.IconLabel(
                                id = R.drawable.ic_baseline_language_24,
                                color = MaterialTheme.colorScheme.onSurface,
                                description = "language"
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.AsciiModeSwitch
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "山人",
                                textInAscii = "En",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 3f,
                            backgroundColor = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Space
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.TextLabel(
                                text = "。",
                                textInAscii = ".",
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                style = MaterialTheme.typography.titleLarge,
                            ),
                            widthWeight = 1f,
                            backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Period
                            )
                        )
                    )
                ),
                LayoutDefinition.KeyboardItemDef.KeyDef(
                    definition = KeyDefinition(
                        appearance = KeyDefinition.Appearance(
                            label = KeyDefinition.Appearance.Label.IconLabel(
                                id = R.drawable.ic_baseline_keyboard_return_24,
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                description = "return"
                            ),
                            widthWeight = 1.5f,
                            backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = MaterialTheme.shapes.extraLarge,
                        ), behavior = KeyDefinition.Behavior(
                            clickAction = KeyDefinition.Behavior.Action.SendKeyCode(
                                keyCode = KeyCode.Enter
                            )
                        )
                    )
                ),
            ),
        )
    )

    GeneralKeyboard(layoutDef = sunmanLayout, onMainContentTypeChange, viewModel)
}

