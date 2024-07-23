package com.example.noteapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.database.NotesData
import com.example.noteapplication.databinding.RecyclerLayoutBinding

class MyAdapter(private val context : Context, private val listNameNumber : MutableList<NotesData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : RecyclerLayoutBinding = RecyclerLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNameNumber.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTextViw.text = listNameNumber[position].title
        holder.binding.desTextView.text = listNameNumber[position].description
    }

}