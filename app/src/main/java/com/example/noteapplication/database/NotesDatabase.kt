package com.example.noteapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NotesData::class] , version = 1)
abstract class NotesDatabase() : RoomDatabase() {
    abstract fun getNotesDao() : NotesDao

    fun buildDatabase(context : Context){
        Room.databaseBuilder(context.applicationContext,NotesDatabase::class.java,"notes.db")
            .allowMainThreadQueries()
            .build()
    }
}