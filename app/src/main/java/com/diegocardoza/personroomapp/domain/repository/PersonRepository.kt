package com.diegocardoza.personroomapp.domain.repository

import com.diegocardoza.personroomapp.domain.model.PersonItem
import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    fun getPersons(): Flow<List<PersonItem>>

    suspend fun insertPerson(personItem: PersonItem)

    suspend fun getPersonById(id: Int): PersonItem?

    suspend fun deletePersonById(id: Int)

}