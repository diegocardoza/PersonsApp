package com.diegocardoza.personroomapp.presentation.screens.person_list

sealed class PersonListEvent {
    data class DeletePerson(val id: Int) : PersonListEvent()
}