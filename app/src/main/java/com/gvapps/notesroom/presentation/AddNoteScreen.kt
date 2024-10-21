package com.gvapps.notesroom.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun AddNoteScreen(
    state: NoteState,
    navController: NavController,
    onEvent: (NotesEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(
                        NotesEvent.SaveNote(
                            title = state.title.value,
                            description = state.description.value
                        )
                    )
                    navController.popBackStack()
                }
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = null)
            }
        },
        modifier = Modifier
            .imePadding()
            .statusBarsPadding()
    ) { padddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TextField(
                value = state.title.value,
                onValueChange = {
                    state.title.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle = TextStyle(
                    fontWeight = SemiBold,
                    fontSize = 17.sp
                ),
                placeholder = {
                    Text("Title")
                }

            )
            TextField(
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = {
                    Text("Description ")
                }

            )
        }

    }
}