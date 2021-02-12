package com.valerie.specialitybank.data.local.converter

import com.valerie.specialitybank.data.local.model.SpecialityWorkerJoin
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker

fun toSpecialityWorkerJoinList(workerList: List<Worker>, specialityList: List<Speciality>) =
    workerList.flatMap {
        val specialityJoinList = it.getSpecialityList(specialityList)
        specialityJoinList.map { speciality ->
            SpecialityWorkerJoin(specialityId = speciality.id, workerId = it.id)
        }
    }
