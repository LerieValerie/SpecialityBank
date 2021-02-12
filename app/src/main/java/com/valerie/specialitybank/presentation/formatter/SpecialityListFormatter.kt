package com.valerie.specialitybank.presentation.formatter

import com.valerie.specialitybank.domain.entity.Speciality

class SpecialityListFormatter {
    companion object {
        fun getListToStr(specialityList: List<Speciality>) =
            specialityList.map { it.name }.joinToString(",\n")
    }
}