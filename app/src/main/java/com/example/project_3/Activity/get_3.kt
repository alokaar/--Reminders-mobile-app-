package com.example.project_3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.project_3.R

class get_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get3)

        val firstbutton = findViewById<Button>(R.id.guestbutton)


        firstbutton.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        val secondbutton = findViewById<Button>(R.id.registerbutton)


        secondbutton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}