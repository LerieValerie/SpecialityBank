package com.valerie.specialitybank.presentation.view

import com.valerie.specialitybank.R
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.formatter.DateFormatter.Companion.getDateWithDot
import com.valerie.specialitybank.presentation.formatter.NameFormatter.Companion.getNameSurname
import kotlinx.datetime.Instant

data class WorkerView(
    val id: Int,
    val fullName: String?,
    val birthDate: String?,
    val imageUrl: String?,
    val age: Int?
)

fun Worker.toView() = WorkerView(
    id = id,
    fullName = getNameSurname(this),
    birthDate = getDateWithDot(birthDate),
    imageUrl = imageUrl,
    age = getAge()
)