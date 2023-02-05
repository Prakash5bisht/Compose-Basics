package com.prakash.composebasics

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun SnackBar(navController: NavController){
    val scaffoldState = rememberScaffoldState()
    var testFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            TextField(
                value = testFieldState,
                label = { Text(text = "Enter your name ") },
                onValueChange = {
                    testFieldState = it
                },
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Submitted", "", SnackbarDuration.Short)
                }
            }) {
                Text(text = "submit")
            }
        }
    }
}