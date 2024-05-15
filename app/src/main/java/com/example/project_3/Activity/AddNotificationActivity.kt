package com.example.project_3.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_3.databinding.ActivityNotificationAdd1Binding
import com.example.project_3.helpers.NotificationsDatabaseHelper


class AddNotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationAdd1Binding
    private lateinit var db:NotificationsDatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationAdd1Binding.inflate(layoutInflater)
        setContentView(binding.root)



        db= NotificationsDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString().trim()
            val content = binding.contentEditText.text.toString().trim()

            if (title.isEmpty()) {
                binding.titleEditText.error = "Title is required"
                binding.titleEditText.requestFocus()
                return@setOnClickListener
            }

            if (content.isEmpty()) {
                binding.contentEditText.error = "Content is required"
                binding.contentEditText.requestFocus()
                return@setOnClickListener
            }

            val notification = Notification(0, title, content)
            db.insertNotification(notification) // Insert the notification into the database
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}


