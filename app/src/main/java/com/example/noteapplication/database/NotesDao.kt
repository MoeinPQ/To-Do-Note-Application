package com.example.noteapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes() : MutableList<NotesData>

    @Insert
    fun insertNotes(notesData: NotesData)

}