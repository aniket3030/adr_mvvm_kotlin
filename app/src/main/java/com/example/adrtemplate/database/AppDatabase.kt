package com.example.adrtemplate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.adrtemplate.database.dao.CategoryDao
import com.example.adrtemplate.database.dao.ContactDao
import com.example.adrtemplate.database.entity.Category
import com.example.adrtemplate.database.entity.Contact

@Database(entities = [Category::class, Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getContactDao(): ContactDao

    companion object{
        val DBName = "AppDB"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DBName
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}