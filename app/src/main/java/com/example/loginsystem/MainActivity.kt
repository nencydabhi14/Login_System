package com.example.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsystem.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.menuImg.setOnClickListener {
//            binding.drawerSlider.()
        }

        binding.registerBtn.setOnClickListener {
            CreateShrd(binding.nameEdt.text.toString(),binding.callEdt.text.toString(), binding.mailEdt.text.toString(), binding.passwordEdt.text.toString())


            if (!binding.cfmPsEdt.text.toString().equals(binding.passwordEdt.text.toString())) {
                binding.cfmPsEdt.setError("Enter Same Password")
                Toast.makeText(this@MainActivity, "Enter Same Password ", Toast.LENGTH_LONG).show()
            } else if (binding.callEdt.text.toString().length < 10 || binding.callEdt.text.toString().length > 13) {
                binding.callEdt.setError("Valid Number")
            }
            else {
                var intent = Intent(this, Login_Screen::class.java)
                startActivity(intent)
            }

//            if (binding.callEdt.text.toString().length < 10 || binding.callEdt.text.toString().length > 13 && binding.nameEdt.text.toString()
//                    .equals("") || binding.mailEdt.text.toString().equals(isEmailValid())
//            ) {
//                Toast.makeText(
//                    this,
//                    "Please enter " + "\n" + " valid phone number",
//                    Toast.LENGTH_SHORT
//                ).show()
//                binding.callEdt.setError("Valid Number")
//
//
//                binding.nameEdt.setError("Enter Name")
//            }
        }
    }


    fun isEmailValid() = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    ).matcher(this@MainActivity.toString()).matches()

    fun CreateShrd(name: String, call: String, email: String, password: String) {
        var sharedPref = this@MainActivity.getSharedPreferences("MyPref", MODE_PRIVATE)
        var editor = sharedPref.edit()
        editor.putString("name", name)
        editor.putString("call", call)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.commit()
    }
}