package com.example.noteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val name = intent.getStringExtra("userName")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}