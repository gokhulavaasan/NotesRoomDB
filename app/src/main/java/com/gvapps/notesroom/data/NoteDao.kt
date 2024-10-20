package com.gvapps.notesroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Select * from note order by dateAdded")
    fun getNotesOrderByDateAdded(): Flow<List<Note>>

    @Query("Select * from note order by title")
    fun getNotesOrderByTitle(): Flow<List<Note>>
}