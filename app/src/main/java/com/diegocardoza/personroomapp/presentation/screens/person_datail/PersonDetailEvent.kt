package com.diegocardoza.personroomapp.presentation.screens.person_datail

sealed class PersonDetailEvent {

    data class OnChangeName(val name:String): PersonDetailEvent()
    data class OnChangeLastname(val lastname:String): PersonDetailEvent()
    data object SavePerson : PersonDetailEvent()

}