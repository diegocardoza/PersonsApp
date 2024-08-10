package com.diegocardoza.personroomapp.presentation.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegocardoza.personroomapp.domain.model.PersonItem

@Composable
fun Person(
    modifier: Modifier = Modifier,
    personItem: PersonItem,
    onClickItem: (Int) -> Unit,
    onDeletePerson: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
            .clickable { onClickItem(personItem.id!!) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { onDeletePerson(personItem.id!!) }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Rounded.Delete,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null
                )
            }
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                .size(80.dp),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = personItem.name.first().uppercase(),
                fontSize = 50.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.primaryContainer
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = personItem.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = personItem.lastName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPerson() {
    val personItem = PersonItem(1, "Diego", "Cardoza")
    Person(
        personItem = personItem,
        modifier = Modifier
            .padding(12.dp),
        onClickItem = {},
        onDeletePerson = {}
    )
}