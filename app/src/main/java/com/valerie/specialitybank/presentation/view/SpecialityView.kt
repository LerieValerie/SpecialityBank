package com.valerie.specialitybank.presentation.view

import com.valerie.specialitybank.domain.entity.Speciality

data class SpecialityView(
    val id: Int,
    val name: String?
)

fun Speciality.toView() = SpecialityView(
    id = id,
    name = name
)