package com.example.project_3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.project_3.R

class notification_add : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_add)

        val secondbutton = findViewById<ImageButton>(R.id.imageButton2)


        secondbutton.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        val thirdbutton = findViewById<ImageButton>(R.id.imageButton4)


        thirdbutton.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

    }
}