package com.example.noteapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.noteapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // sharePreferences : 1.preferences  2.editor

        preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        editor = preferences.edit()
        editor.apply()

        val firstEntery: Boolean = preferences.getBoolean("firstEnter", true)
        if(!firstEntery)
            binding.enterButton.text = "ورود"

        binding.enterButton.setOnClickListener {

            val userEditText = binding.userNameEditText.text.toString()
            val passwordEditText = binding.passEditText.text.toString()

            if (userEditText.isEmpty() || passwordEditText.isEmpty()) {
                // 'TextUtils.isEmpty(passwordEditText)' -> another way for checking empty.
                Toast.makeText(this, getString(R.string.login_toast_message), Toast.LENGTH_SHORT).show()
            } else {


                if (firstEntery) {
                    editor.putString("userSave", userEditText).apply()
                    editor.putString("passSave", passwordEditText).apply()
                    editor.putBoolean("firstEnter", false).apply()
                    goMainActivity(userEditText)

                } else {
                    val savedUserName = preferences.getString("userSave", null)
                    val savedPassword = preferences.getString("passSave", null)
                    if (userEditText == savedUserName && passwordEditText == savedPassword) {
                        goMainActivity(userEditText)
                    } else {
                        Toast.makeText(this, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    private fun goMainActivity(userEditText : String){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("userName", userEditText)
        startActivity(intent)
        finish()
    }
}