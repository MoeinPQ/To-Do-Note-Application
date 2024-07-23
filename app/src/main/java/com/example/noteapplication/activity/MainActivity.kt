package com.example.noteapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.database.NotesData
import com.example.noteapplication.adapter.MyAdapter
import com.example.noteapplication.database.NotesDao
import com.example.noteapplication.database.NotesDatabase
import com.example.noteapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDao = NotesDatabase.buildDatabase(this).getNotesDao()

        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//        binding.recyclerView.layoutManager = GridLayoutManager
        val adapter = MyAdapter(this, selectFromDb())
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            val intent = Intent(this , AddNotesActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun selectFromDb() = notesDao.getAllNotes()
}