package com.valerie.specialitybank.data.remote.transformation

import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toKotlinLocalDate
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateTransform {

    companion object {
        private val formatter = DateTimeFormatter.ofPattern(
            "[yyyy-MM-dd]" +
                    "[dd-MM-yyyy]"
        )

        fun toKotlinInstant(str: String?) =
            if (!str.isNullOrEmpty()) {
                val localDate = LocalDate.parse(str, formatter).toKotlinLocalDate()
                localDate.atStartOfDayIn(TimeZone.currentSystemDefault())
            } else {
                null
            }
    }
}