package com.example.noteapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.DataClass
import com.example.noteapplication.MyAdapter
import com.example.noteapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nameNumberList = mutableListOf<DataClass>()
        nameNumberList.add(DataClass("عنوان یادداشت ۱", "توضیحات"))
        nameNumberList.add(DataClass("عنوان یادداشت ۲", "توضیحات"))
        nameNumberList.add(DataClass("عنوان یادداشت ۳", "توضیحات"))
        nameNumberList.add(DataClass("عنوان یادداشت ۴", "توضیحات"))
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//        binding.recyclerView.layoutManager = GridLayoutManager
        val adapter = MyAdapter(this, nameNumberList)
        binding.recyclerView.adapter = adapter

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