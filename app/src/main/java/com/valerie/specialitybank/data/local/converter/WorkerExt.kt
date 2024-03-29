package com.valerie.specialitybank.data.local.converter

import com.valerie.specialitybank.data.local.model.WorkerModel
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import kotlinx.datetime.Instant

fun Worker.toModel() = WorkerModel(
        workerId = id,
        name = name,
        surname = surname,
        birthDate = birthDate?.toLong(),
        imageUrl = imageUrl
)

fun List<Worker>.toWorkerModelList() = map { it.toModel() }

fun Worker.getSpecialityList(specialityFullList: List<Speciality>) =
    specialityFullList.filter { specialityIdList.contains(it.id) }

fun WorkerModel.toEntity() = Worker(
        id = workerId,
        name = name,
        surname = surname,
        birthDate = birthDate?.toInstant(),
        imageUrl = imageUrl,
        specialityIdList = listOf()
)

private fun Instant.toLong(): Long = this.toEpochMilliseconds()

private fun Long.toInstant() = this.let {
    Instant.fromEpochMilliseconds(it)
}