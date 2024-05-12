package com.example.project_3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.project_3.R
import com.example.project_3.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.addreminderbutton.setOnClickListener{
            val intent = Intent(this, AddNotificationActivity::class.java)
        }





        val firstbutton = findViewById<Button>(R.id.button7)


        firstbutton.setOnClickListener {
            val intent = Intent(this, notification_add::class.java)
            startActivity(intent)
        }

        val secondbutton = findViewById<ImageView>(R.id.imageView16)


        secondbutton.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }


        val abutton = findViewById<Button>(R.id.addreminderbutton)

        abutton.setOnClickListener {
            val intent = Intent(this, AddNotificationActivity::class.java)
            startActivity(intent)
        }

        val dbutton = findViewById<ImageView>(R.id.imageView12)
        dbutton.setOnClickListener {
            val intent = Intent(this, NotificationDisplayActivity::class.java)
            startActivity(intent)
        }




    }
}