package com.valerie.specialitybank.data.remote.transformation

import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toKotlinLocalDate
import java.lang.NullPointerException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateTransform {

    companion object {
        private val formatter = DateTimeFormatter.ofPattern(
                "[yyyy-MM-dd]" +
                        "[dd-MM-yyyy]"
        )

        fun String.toKotlinInstant() =
            if (!isNullOrEmpty()) {
                try {
                    val localDate = LocalDate.parse(this, formatter).toKotlinLocalDate()
                    localDate.atStartOfDayIn(TimeZone.currentSystemDefault())
                } catch (ex: NullPointerException) {
                    null
                }
            } else {
                null
            }
    }
}