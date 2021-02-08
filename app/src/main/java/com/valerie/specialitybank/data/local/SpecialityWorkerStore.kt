package com.valerie.specialitybank.data.local

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.valerie.specialitybank.domain.entity.Worker

data class SpecialityWorkerStore(
    @Embedded
    val speciality : SpecialityModel,
    @Relation(
        parentColumn = "specialityId",
//        entity = WorkerModel::class,
        entityColumn = "workerId",
        associateBy = Junction(SpecialityWorkerJoin::class,
            parentColumn = "specialityId",
            entityColumn = "workerId"
        )
    )

    val workerList: List<WorkerModel>
)
