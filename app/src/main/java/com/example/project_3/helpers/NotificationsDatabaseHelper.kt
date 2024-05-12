package com.example.project_3.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.project_3.Activity.Notification

class NotificationsDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "notificationsapp.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "allnotifications"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT = "content"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITLE TEXT, $COLUMN_CONTENT TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertNotification(notification: Notification){
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, notification.title)
            put(COLUMN_CONTENT, notification.content)

        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllNotifications(): List<Notification> {
        val notificationList = mutableListOf<Notification>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query,null)

        while(cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            val notification = Notification(id, title, content)
            notificationList.add(notification)
        }
          cursor.close()
        db.close()
        return notificationList
    }

    fun updateNotitfication(notification: Notification){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE,notification.title)
            put(COLUMN_CONTENT,notification.content)
        }

        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(notification.id.toString())
        db.update(TABLE_NAME,values,whereClause,whereArgs)
        db.close()
    }

    fun getNotificationById(notificationId : Int) : Notification{
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = $notificationId"
        val cursor = db.rawQuery(query,null)
        cursor.moveToFirst()

        val id = cursor.getInt((cursor.getColumnIndexOrThrow(COLUMN_ID)))
        val title = cursor.getString((cursor.getColumnIndexOrThrow(COLUMN_TITLE)))
        val content = cursor.getString((cursor.getColumnIndexOrThrow(COLUMN_CONTENT)))

        cursor.close()
        db.close()
        return Notification(id, title, content)
    }

    fun deleteNotification(notificationId: Int){
        val db = writableDatabase
        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(notificationId.toString())
        db.delete(TABLE_NAME,whereClause,whereArgs)
        db.close()
    }
}
