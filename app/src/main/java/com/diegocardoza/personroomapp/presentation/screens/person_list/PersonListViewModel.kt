package com.diegocardoza.personroomapp.presentation.screens.person_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _state = mutableStateOf(PersonListState())
    val state: State<PersonListState> = _state

    init {
        getPersonsUseCase().onEach { persons ->
            _state.value = _state.value.copy(
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