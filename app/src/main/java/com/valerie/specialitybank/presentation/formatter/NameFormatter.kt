package com.valerie.specialitybank.presentation.formatter

import com.valerie.specialitybank.domain.entity.Worker

class NameFormatter {
    companion object {
        fun getNameSurname(worker: Worker) = "${worker.surname} ${worker.name}"
    }
}