package com.valerie.specialitybank.presentation.transformation

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toLocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalQueries.localDate

class DateTransform {
    companion object {
        fun getDateWithDot(dateInstant: Instant?) = run {
            val localDate = dateInstant?.toLocalDateTime(TimeZone.currentSystemDefault())?.date?.toJavaLocalDate()
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            if (localDate != null) {
                try {
                    localDate.format(formatter)
                } catch (ex: NullPointerException) {
                    "-"
                }
            } else {
                "-"
            }
        }
    }
}