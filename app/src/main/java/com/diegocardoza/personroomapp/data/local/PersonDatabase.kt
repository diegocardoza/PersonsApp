package com.diegocardoza.personroomapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diegocardoza.personroomapp.data.local.dao.PersonDao
import com.diegocardoza.personroomapp.data.local.entities.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun getPersonDao(): PersonDao

}