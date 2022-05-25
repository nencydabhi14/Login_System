package com.example.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsystem.databinding.ActivityLoginScreenBinding
import com.example.loginsystem.databinding.ActivitySplashPageBinding

class Splash_page : AppCompatActivity() {

    lateinit var binding: ActivitySplashPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ragisterSplash.setOnClickListener {

            if(binding.splashLogMailEdt.text.toString().equals("") &&  binding.splashLogPasswordEdt.text.toString().equals("")){
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Don't Need Register\n You are already User", Toast.LENGTH_LONG).show()
            }
        }

        binding.loginSplash.setOnClickListener {

            if (binding.splashLogMailEdt.text.toString() == "nency.90.dabhi@gmail.com" && binding.splashLogPasswordEdt.text.toString() == "nency143") {

                var intent = Intent(this, HomePage_Screen::class.java)
                startActivity(intent) }

            else  {
                Toast.makeText(this, "User Not Found\n Please Register Hear", Toast.LENGTH_LONG).show()
            }
        }
    }
}