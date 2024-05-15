package com.example.project_3.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project_3.databinding.ActivityNotificationUdBinding
import com.example.project_3.helpers.NotificationsDatabaseHelper

class UpdateNotificationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNotificationUdBinding
    private lateinit var db : NotificationsDatabaseHelper
    private var notificationId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationUdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotificationsDatabaseHelper(this)

        notificationId = intent.getIntExtra("notification_id", -1)
        if(notificationId == -1){
            finish()
             return
    }

    val notification = db.getNotificationById(notificationId)
        binding.updatetitleEditText.setText(notification.title)
        binding.updatecontentEditText.setText(notification.content)

       binding.updatesaveButton.setOnClickListener {
           val newTitle = binding.updatetitleEditText.text.toString()
           val newContent = binding.updatecontentEditText.text.toString()
           if (newTitle.isBlank() || newContent.isBlank()) {
               Toast.makeText(this, "Title and Content cannot be empty", Toast.LENGTH_SHORT).show()
           } else {
               val updatedNotification = Notification(notificationId, newTitle, newContent)
               db.updateNotitfication(updatedNotification)
               finish()
               Toast.makeText(this, "Changes Saved successfully", Toast.LENGTH_SHORT).show()
           }
       }
}
}