package com.example.project_3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.project_3.R

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val firstbutton = findViewById<Button>(R.id.editTextText6)


        firstbutton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val secondbutton = findViewById<ImageView>(R.id.imageView3)


        secondbutton.setOnClickListener {
            val intent = Intent(this, NotificationDisplayActivity::class.java)
            startActivity(intent)
        }
        val thirdbutton = findViewById<ImageView>(R.id.imageView6)


        thirdbutton.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}