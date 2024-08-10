package com.diegocardoza.personroomapp.domain.use_cases

import com.diegocardoza.personroomapp.domain.model.PersonItem
import com.diegocardoza.personroomapp.domain.repository.PersonRepository
import javax.inject.Inject

class InsertPersonUseCase @Inject constructor(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(person: PersonItem) = repository.insertPerson(person)

}