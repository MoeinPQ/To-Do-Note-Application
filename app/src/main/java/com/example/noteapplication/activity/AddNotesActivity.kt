package com.example.noteapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapplication.R
import com.example.noteapplication.database.NotesDao
import com.example.noteapplication.database.NotesData
import com.example.noteapplication.database.NotesDatabase
import com.example.noteapplication.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDao = NotesDatabase.buildDatabase(this).getNotesDao()

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val des = binding.desEditText.text.toString()
            val notesData = NotesData(title = title, description = des)
            notesDao.insertNotes(notesData)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}