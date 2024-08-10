package com.diegocardoza.personroomapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diegocardoza.personroomapp.data.local.entities.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: PersonEntity)

    @Query("DELETE FROM person WHERE id = :id")
    suspend fun deletePersonById(id: Int)

    @Query("SELECT * FROM person WHERE id = :id")
    suspend fun getPersonById(id: Int): PersonEntity?

    @Query("SELECT * FROM person ORDER BY id")
    fun getPersons(): Flow<List<PersonEntity>>

}