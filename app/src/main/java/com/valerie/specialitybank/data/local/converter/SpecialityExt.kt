package com.valerie.specialitybank.data.local.converter

import com.valerie.specialitybank.data.local.SpecialityModel
import com.valerie.specialitybank.domain.entity.Speciality

fun Speciality.toModel() = SpecialityModel(
        specialityId = id,
        name = name
)

fun SpecialityModel.toEntity() = Speciality(
        id = specialityId,
        name = name
)

fun List<Speciality>.toSpecialityModelList() = map { it.toModel() }