package com.gvapps.notesroom.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.gvapps.notesroom.data.Note

data class NoteState(
    val notes: List<Note> = emptyList(),
    val title: MutableState<String> = mutableStateOf("null"),
    val description: MutableState<String> = mutableStateOf("null")
)
