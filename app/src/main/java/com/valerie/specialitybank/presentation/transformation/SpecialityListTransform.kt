package com.valerie.specialitybank.presentation.transformation

import com.valerie.specialitybank.domain.entity.Speciality

class SpecialityListTransform {
    companion object {
        fun getListToStr(specialityList : List<Speciality>)  =
                specialityList.map { it.name }.joinToString(",\n")
    }
}