/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codelabs.state

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


//@Composable
//fun WellnessTaskItemStateFull(
//    taskName: String,
//    checked: Boolean,
//    onCheckedChange: (Boolean) -> Unit,
//    onClose: (WellnessTask) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    var checkedState by rememberSaveable { mutableStateOf(checked) }
//    WellnessTaskItem(
//        taskName = taskName,
//        checked = checkedState,
//        onCheckedChange = {
//            checkedState = it
//            onCheckedChange(it)
//        },
//        onClose = onClose,
//        modifier = modifier
//    )
//}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}


@Composable
fun WellnessTaskItemStateLess(taskName:String,checked:Boolean,
                              oncheckedChange:(Boolean) -> Unit,
                              checkClicked: () -> Unit,
                              modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(modifier = Modifier
            .weight(1f)
            .padding(16.dp),text = taskName)
        Checkbox(checked = checked, onCheckedChange = oncheckedChange)
        IconButton(onClick = checkClicked) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }

}

@Composable
fun WellnessTaskItemStateFull(
    taskName: String,
    onClose: () -> Unit,
    oncheckedChange:(Boolean) -> Unit,
    modifier: Modifier = Modifier) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
    WellnessTaskItemStateLess(
        taskName = taskName,
        checked = checkedState,
        oncheckedChange = oncheckedChange,
        checkClicked = onClose)

}
