package com.diegocardoza.personroomapp.presentation.screens.person_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocardoza.personroomapp.domain.use_cases.DeletePersonByIdUseCase
import com.diegocardoza.personroomapp.domain.use_cases.GetPersonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonListViewModel @Inject constructor(
    getPersonsUseCase: GetPersonsUseCase,
    private val deletePersonByIdUseCase: DeletePersonByIdUseCase
) : ViewModel() {

    var state by mutableStateOf(PersonListState())
        private set

    init {
        getPersonsUseCase().onEach { persons ->
            state = state.copy(
                persons = persons
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: PersonListEvent) {
        when (event) {
            is PersonListEvent.DeletePerson -> viewModelScope.launch {
                deletePersonByIdUseCase(event.id)
            }
        }
    }


}