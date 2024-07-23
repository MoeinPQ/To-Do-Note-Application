package com.example.noteapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.noteapplication.R
import com.example.noteapplication.database.NotesDao
import com.example.noteapplication.database.NotesData
import com.example.noteapplication.database.NotesDatabase
import com.example.noteapplication.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var notesDao: NotesDao
    private var showNotes : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDao = NotesDatabase.buildDatabase(this).getNotesDao()

        val intent = intent
        showNotes = intent.getBooleanExtra("showActivity" , false)
        val position = intent.getIntExtra("position" , 0)
        if(showNotes){
            binding.saveButton.visibility = View.INVISIBLE
            binding.textView3.text = "نمایش یادداشت"
            binding.titleEditText.isFocusable = false
            binding.desEditText.isFocusable = false
            binding.titleEditText.setText(selectFromDb()[position].title)
            binding.desEditText.setText(selectFromDb()[position].description)
        }

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val des = binding.desEditText.text.toString()
            val notesData = NotesData(title = title, description = des)
            notesDao.insertNotes(notesData)
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "یادداشت با موفقیت اضافه شد", Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectFromDb() = notesDao.getAllNotes()
}