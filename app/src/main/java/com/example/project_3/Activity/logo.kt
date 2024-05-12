package com.example.project_3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.project_3.R

class logo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        val firstbutton = findViewById<Button>(R.id.button)


        firstbutton.setOnClickListener {
            val intent = Intent(this, get_3::class.java)
            startActivity(intent)
        }


    }
    }
