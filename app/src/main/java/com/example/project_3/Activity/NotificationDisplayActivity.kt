package com.example.project_3.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_3.adapter.NotificationsAdapter
import com.example.project_3.databinding.ActivityNotificationDisplayBinding

import com.example.project_3.helpers.NotificationsDatabaseHelper

class NotificationDisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationDisplayBinding
    private lateinit var db : NotificationsDatabaseHelper
    private lateinit var notificationsAdapter: NotificationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotificationsDatabaseHelper(this)
        notificationsAdapter = NotificationsAdapter(db.getAllNotifications(), this)

        binding.notificationsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.notificationsRecyclerView.adapter = notificationsAdapter
    }

    override fun onResume() {
        super.onResume()
        // Refresh data in the adapter if needed
        notificationsAdapter.refreshData(db.getAllNotifications())
    }
}
