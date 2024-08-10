package com.diegocardoza.personroomapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class PersonDetail(val personId: Int)