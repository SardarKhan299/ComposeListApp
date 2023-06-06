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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}

@Preview
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    // rememberSaveable is a composable's Api or state Management Api
    // which is used to save the state of the composable on configuration changes
    // and also for Activity and Process Creation..//
    var count by rememberSaveable { mutableStateOf(0) }
    // -------
    StateLessCounter(count,{count++},modifier)
}


@Composable
private fun StateLessCounter(count: Int,onIncrement: () -> Unit, modifier: Modifier= Modifier) {

    Column(modifier = Modifier.padding(16.dp)) {

        // mutableState is a composable's Api or state Management Api
        // that can hold a value and recompose
        //var count : MutableState<Int> = remember { mutableStateOf(0) }

        // another way of declaring mutableState
        //var count by remember { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had ${count} glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            // Label on the button
            Text("Add one")
        }

    }
}
