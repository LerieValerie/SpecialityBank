package com.valerie.specialitybank.presentation.transformation

import com.valerie.specialitybank.domain.entity.Worker

class NameTransform {
    companion object {
        fun getNameSurname(worker: Worker) = "${worker.surname} ${worker.name}"
    }
}