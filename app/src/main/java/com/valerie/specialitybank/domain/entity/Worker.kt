package com.valerie.specialitybank.domain.entity

import kotlinx.datetime.*
import java.text.ParseException
import java.text.SimpleDateFormat


data class Worker(
        val id: Int,
        val name: String?,
        val surname: String?,
        val birthDate: Instant?,
        val imageUrl: String?,
        val specialityIdList: List<Int>
) {
    fun getAge() : Int {
        var age: Int = 0
        val currentDate = Clock.System.now()
//        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

        if (birthDate != null) {
            age = birthDate.yearsUntil(currentDate, TimeZone.currentSystemDefault())
        }
        return age
    }
}

