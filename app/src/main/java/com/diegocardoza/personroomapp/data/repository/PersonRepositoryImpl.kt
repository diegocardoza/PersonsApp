package com.diegocardoza.personroomapp.data.repository

import com.diegocardoza.personroomapp.data.local.dao.PersonDao
import com.diegocardoza.personroomapp.domain.model.PersonItem
import com.diegocardoza.personroomapp.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val dao: PersonDao
) : PersonRepository {

    override fun getPersons(): Flow<List<PersonItem>> =
        dao.getPersons().map { list -> list.map { it.toDomain() } }


    override suspend fun insertPerson(personItem: PersonItem) {
        dao.insertPerson(personItem.toEntity())
    }

    override suspend fun getPersonById(id: Int): PersonItem? =
        dao.getPersonById(id)?.toDomain()

    override suspend fun deletePersonById(id: Int) {
        dao.deletePersonById(id)
    }
}