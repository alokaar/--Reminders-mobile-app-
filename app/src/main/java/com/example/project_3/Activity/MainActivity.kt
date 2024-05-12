package com.example.project_3.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent
import com.example.project_3.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstbutton = findViewById<ImageView>(R.id.imageView2)


        firstbutton.setOnClickListener{
            val intent = Intent (this, logo::class.java)
            startActivity(intent)
        }
    }
}