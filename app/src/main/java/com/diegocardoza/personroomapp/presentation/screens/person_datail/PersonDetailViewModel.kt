package com.diegocardoza.personroomapp.presentation.screens.person_datail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    private var _lastname: MutableState<String> = mutableStateOf("")
    val lastname: State<String> = _lastname

    var _uiEvent = MutableSharedFlow<PersonDetailUiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    private var currentPersonId: Int? = null

    init {
        savedStateHandle.get<Int>("personId")?.let { personId ->
            viewModelScope.launch {
                getPersonByIdUseCase(personId)?.let { person ->
                    currentPersonId = person.id
                    _name.value = person.name
                    _lastname.value = person.lastName
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
                            id = currentPersonId,
                            name = _name.value,
                            lastName = _lastname.value
                        )
                    insertPersonUseCase(personItem)
                    _uiEvent.emit(PersonDetailUiEvent.SavePersonTapped)
                }
            }

            is PersonDetailEvent.OnChangeLastname -> _lastname.value = event.lastname
            is PersonDetailEvent.OnChangeName -> _name.value = event.name
        }
    }

}

sealed class PersonDetailUiEvent {
    data object SavePersonTapped : PersonDetailUiEvent()
}