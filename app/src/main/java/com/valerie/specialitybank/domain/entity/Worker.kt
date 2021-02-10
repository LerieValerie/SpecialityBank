package com.valerie.specialitybank.domain.entity

import kotlinx.datetime.*

data class Worker(
        val id: Int,
        val name: String?,
        val surname: String?,
        val birthDate: Instant?,
        val imageUrl: String?,
        val specialityIdList: List<Int>
) {
    fun getAge()= birthDate?.yearsUntil(Clock.System.now(), TimeZone.currentSystemDefault())
}

