package com.diegocardoza.personroomapp.presentation.componets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diegocardoza.personroomapp.domain.model.PersonItem
import com.diegocardoza.personroomapp.presentation.screens.person_list.PersonListState

@Composable
fun PersonList(
    modifier: Modifier = Modifier,
    state: PersonListState,
    onClickItem: (Int) -> Unit,
    onDeletePerson: (Int) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier
    ) {
        items(state.persons.size) {
            Person(
                modifier = Modifier
                    .padding(12.dp),
                personItem = state.persons[it],
                onClickItem = onClickItem,
                onDeletePerson = onDeletePerson
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewPersonList() {
    val personList = listOf(
        PersonItem(1, "Diego", "Cardoza"),
        PersonItem(1, "Juan", "Perez"),
        PersonItem(1, "Rosa", "Fuentes"),
        PersonItem(1, "Estefania", "Solis")
    )
    val previewState = PersonListState(persons = personList)
    PersonList(
        modifier = Modifier.fillMaxSize(),
        state = previewState,
        onClickItem = {},
        onDeletePerson = {})
}