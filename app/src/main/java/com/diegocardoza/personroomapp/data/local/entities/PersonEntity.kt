package com.diegocardoza.personroomapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegocardoza.personroomapp.domain.model.PersonItem

@Entity(
    tableName = "person"
)
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "last_name")
    val lastName: String
) {
    fun toDomain(): PersonItem =
        PersonItem(
            id = id,
            name = name,
            lastName = lastName
        )
}
