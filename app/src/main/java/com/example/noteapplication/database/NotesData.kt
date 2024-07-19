package com.example.noteapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class NotesData(

    @PrimaryKey
    val id : Int,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "description")
    val description : String

    ) {
}