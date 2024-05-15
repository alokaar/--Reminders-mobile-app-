package com.example.project_3.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        setupSearchFunctionality()
    }

    override fun onResume() {
        super.onResume()
        // Refresh data in the adapter if needed
        notificationsAdapter.refreshData(db.getAllNotifications())
    }
    private fun setupSearchFunctionality() {
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterNotifications(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterNotifications(query: String) {
        val allNotifications = db.getAllNotifications()
        val filteredNotifications = allNotifications.filter { notification ->
            notification.title.contains(query, ignoreCase = true) ||
                    notification.content.contains(query, ignoreCase = true)
        }
        notificationsAdapter.refreshData(filteredNotifications)
    }
}

