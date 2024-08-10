package com.diegocardoza.personroomapp.domain.model

import com.diegocardoza.personroomapp.data.local.entities.PersonEntity

data class PersonItem(
    val id: Int? = null,
    val name: String = "",
    val lastName: String = ""
) {
    fun toEntity(): PersonEntity =
        PersonEntity(
            id = id ?: 0,
            name = name,
            lastName = lastName
        )
}
