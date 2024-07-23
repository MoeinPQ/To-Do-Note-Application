package com.example.noteapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.database.NotesData
import com.example.noteapplication.adapter.MyAdapter
import com.example.noteapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nameNumberList = mutableListOf<NotesData>()
//        nameNumberList.add(NotesData("عنوان یادداشت ۱", "توضیحات"))
//        nameNumberList.add(NotesData("عنوان یادداشت ۲", "توضیحات"))
//        nameNumberList.add(NotesData("عنوان یادداشت ۳", "توضیحات"))
//        nameNumberList.add(NotesData("عنوان یادداشت ۴", "توضیحات"))
//        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
////        binding.recyclerView.layoutManager = GridLayoutManager
//        val adapter = MyAdapter(this, nameNumberList)
//        binding.recyclerView.adapter = adapter

        var i = 4
        binding.addButton.setOnClickListener {
            val intent = Intent(this , AddNotesActivity::class.java)
            startActivity(intent)
//            nameNumberList.add(DataClass(i.toString() + "عنوان یادداشت", "توضیحات"))
//            i++
//            adapter.notifyDataSetChanged() // this line report our list changes to adapter.
        }

    }
}