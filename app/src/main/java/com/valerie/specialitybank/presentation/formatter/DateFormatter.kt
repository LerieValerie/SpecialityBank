package com.valerie.specialitybank.presentation.formatter

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toLocalDateTime
import java.time.format.DateTimeFormatter

class DateFormatter {
    companion object {
        fun getDateWithDot(dateInstant: Instant?): String? {
            val formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy")
            return dateInstant?.toLocalDateTime(TimeZone.currentSystemDefault())?.date?.toJavaLocalDate()?.format(formatter)
        }
    }
}