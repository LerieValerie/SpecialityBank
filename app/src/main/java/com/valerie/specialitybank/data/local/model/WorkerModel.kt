package com.valerie.specialitybank.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "worker")
data class WorkerModel(
    @PrimaryKey(autoGenerate = true)
    val workerId: Int,
    val name: String?,
    val surname: String?,
    val birthDate: Long?,
    val imageUrl: String?
)
