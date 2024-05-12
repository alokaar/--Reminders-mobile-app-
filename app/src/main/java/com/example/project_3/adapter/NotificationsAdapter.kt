package com.example.project_3.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.project_3.Activity.Notification
import com.example.project_3.Activity.UpdateNotificationActivity
import com.example.project_3.R
import com.example.project_3.helpers.NotificationsDatabaseHelper

class NotificationsAdapter(private var notifications: List<Notification>, private val context: Context) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>() {

   private val db: NotificationsDatabaseHelper = NotificationsDatabaseHelper(context)
    class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentEditTextView)
        val updateButton: ImageView = itemView.findViewById(R.id.updateButton)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_item, parent, false)
        return NotificationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]
        holder.titleTextView.text = notification.title
        holder.contentTextView.text = notification.content

        holder.updateButton.setOnClickListener{
            val intent = Intent(holder.itemView.context, UpdateNotificationActivity::class.java).apply {
                putExtra("notification_id", notification.id)

            }

            holder.itemView.context.startActivity(intent)
        }
            holder.deleteButton.setOnClickListener{
                db.deleteNotification(notification.id)
                refreshData(db.getAllNotifications())
                Toast.makeText(holder.itemView.context,"Notification is Deleted", Toast.LENGTH_SHORT).show()
            }
    }

    fun refreshData(newNotifications: List<Notification>) {
        notifications = newNotifications
        notifyDataSetChanged()
    }
}
