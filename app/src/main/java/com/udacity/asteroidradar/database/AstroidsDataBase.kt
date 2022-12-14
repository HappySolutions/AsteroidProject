package com.udacity.asteroidradar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.Asteroid

@Database(entities = [Asteroid::class], version = 1, exportSchema = false)
abstract class AstroidsDataBase : RoomDatabase() {
    abstract val astroidsDatabaseDao: AstroidsDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: AstroidsDataBase? = null

        fun getInstance(context: Context): AstroidsDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AstroidsDataBase::class.java,
                        "astroids_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}