package com.diegocardoza.personroomapp.presentation.screens.person_list

import com.diegocardoza.personroomapp.domain.model.PersonItem

data class PersonListState(
    val persons: List<PersonItem> = emptyList()
)
