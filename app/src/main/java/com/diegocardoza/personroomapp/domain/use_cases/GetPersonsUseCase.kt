package com.diegocardoza.personroomapp.domain.use_cases

import com.diegocardoza.personroomapp.domain.model.PersonItem
import com.diegocardoza.personroomapp.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPersonsUseCase @Inject constructor(
    private val repository: PersonRepository
) {

    operator fun invoke(): Flow<List<PersonItem>> = repository.getPersons()

}