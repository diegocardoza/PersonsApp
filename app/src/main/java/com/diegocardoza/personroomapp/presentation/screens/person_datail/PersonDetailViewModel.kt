package com.diegocardoza.personroomapp.presentation.screens.person_datail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocardoza.personroomapp.domain.model.PersonItem
import com.diegocardoza.personroomapp.domain.use_cases.GetPersonByIdUseCase
import com.diegocardoza.personroomapp.domain.use_cases.InsertPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    private val getPersonByIdUseCase: GetPersonByIdUseCase,
    private val insertPersonUseCase: InsertPersonUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(PersonDetailState())
        private set

    private var _uiEvent = MutableSharedFlow<PersonDetailUiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    init {
        savedStateHandle.get<Int>("personId")?.let { personId ->
            viewModelScope.launch {
                if (personId != -1) {
                    getPersonByIdUseCase(personId)?.let { person ->
                        state = state.copy(
                            id = person.id,
                            name = person.name,
                            lastname = person.lastName
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: PersonDetailEvent) {
        when (event) {
            PersonDetailEvent.SavePerson -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val personItem =
                        PersonItem(
                            id = state.id,
                            name = state.name,
                            lastName = state.lastname
                        )
                    insertPersonUseCase(personItem)
                    _uiEvent.emit(PersonDetailUiEvent.SavePersonTapped)
                }
            }

            is PersonDetailEvent.OnChangeLastname -> state = state.copy(lastname = event.lastname)
            is PersonDetailEvent.OnChangeName -> state = state.copy(name = event.name)
        }
    }

}

sealed class PersonDetailUiEvent {
    data object SavePersonTapped : PersonDetailUiEvent()
}