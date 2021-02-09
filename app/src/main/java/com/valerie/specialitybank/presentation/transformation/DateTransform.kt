package com.valerie.specialitybank.presentation.transformation

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toLocalDateTime
import java.time.format.DateTimeFormatter

class DateTransform {
    companion object {
        fun getDateWithDot(dateInstant: Instant?): String? {
            val formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy")
            return dateInstant?.toLocalDateTime(TimeZone.currentSystemDefault())?.date?.toJavaLocalDate()?.format(formatter)
        }
    }
}