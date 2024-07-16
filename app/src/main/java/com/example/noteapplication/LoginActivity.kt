package com.example.noteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enterButton.setOnClickListener {

            val userEditText = binding.userNameEditText.text.toString()
            val passwordEditText = binding.passEditText.text.toString()

            if(userEditText.isEmpty() || passwordEditText.isEmpty()) {
                Toast.makeText(this, "لطفا تمامی مقادیر را پر کنید", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("userName", userEditText)
                startActivity(intent)
            }
        }
    }
}