package com.diegocardoza.personroomapp.presentation.screens.person_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.diegocardoza.personroomapp.presentation.componets.PersonList
import com.diegocardoza.personroomapp.presentation.navigation.PersonDetail

@Composable
fun PersonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PersonListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state
    PersonList(
        modifier = modifier,
        state = state,
        onClickItem = { navController.navigate(PersonDetail(it)) },
        onDeletePerson = { viewModel.onEvent(PersonListEvent.DeletePerson(it)) })
}
