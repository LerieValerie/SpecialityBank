package com.valerie.specialitybank.presentation.transformation

class AgeTransform {
    companion object {
        fun getAgeStr(age : Int) = if (age > 0) age.toString() else "-"
    }
}