package com.example.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsystem.databinding.ActivityLoginScreenBinding
import com.example.loginsystem.databinding.ActivityMainBinding

class Login_Screen : AppCompatActivity() {

    lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedPref = this.getSharedPreferences("MyPref",MODE_PRIVATE)
        var mail = sharedPref.getString("email",null)
        var pass = sharedPref.getString("password",null)


        binding.loginBtn.setOnClickListener {
            if (binding.logMailEdt.text.toString() == mail  && binding.logPasswordEdt.text.toString() == pass){
                var intent = Intent(this, HomePage_Screen::class.java)
                startActivity(intent) }
            if (!binding.logMailEdt.text.toString().equals(mail)){
                Toast.makeText(this@Login_Screen, "Enter Correct E-mail", Toast.LENGTH_LONG).show()
            }
            if (!binding.logPasswordEdt.text.toString().equals(pass)){
                Toast.makeText(this@Login_Screen, "Enter Correct Password", Toast.LENGTH_LONG).show()
            }
        }
    }
}