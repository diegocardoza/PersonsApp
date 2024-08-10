package com.diegocardoza.personroomapp.domain.use_cases

import com.diegocardoza.personroomapp.domain.model.PersonItem
import com.diegocardoza.personroomapp.domain.repository.PersonRepository
import javax.inject.Inject

class GetPersonByIdUseCase @Inject constructor(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(id: Int): PersonItem? = repository.getPersonById(id)

}