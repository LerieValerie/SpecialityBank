package com.valerie.specialitybank.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "speciality")
data class SpecialityModel(
    @PrimaryKey
    val specialityId: Int,
    val name: String?
)
