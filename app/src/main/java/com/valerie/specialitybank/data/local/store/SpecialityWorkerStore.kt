package com.valerie.specialitybank.data.local.store

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.valerie.specialitybank.data.local.model.SpecialityModel
import com.valerie.specialitybank.data.local.model.SpecialityWorkerJoin
import com.valerie.specialitybank.data.local.model.WorkerModel

data class SpecialityWorkerStore(
    @Embedded
    val speciality : SpecialityModel,
    @Relation(
        parentColumn = "specialityId",
        entityColumn = "workerId",
        associateBy = Junction(
            SpecialityWorkerJoin::class,
            parentColumn = "specialityId",
            entityColumn = "workerId"
        )
    )

    val workerList: List<WorkerModel>
)
