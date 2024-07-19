package com.example.noteapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapplication.R
import com.example.noteapplication.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}