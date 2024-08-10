package com.diegocardoza.personroomapp.domain.use_cases

import com.diegocardoza.personroomapp.domain.repository.PersonRepository
import javax.inject.Inject

class DeletePersonByIdUseCase @Inject constructor(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(id: Int) = repository.deletePersonById(id)

}