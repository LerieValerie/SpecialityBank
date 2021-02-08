package com.valerie.specialitybank.data.local

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class WorkerSpecialityStore(
        @Embedded
        val worker: WorkerModel,
        @Relation(
                parentColumn = "workerId",
//                entity = SpecialityModel::class,
                entityColumn = "specialityId",
                associateBy = Junction(SpecialityWorkerJoin::class,
            parentColumn = "workerId",
            entityColumn = "specialityId"
                )
        )

        val specialityList: List<SpecialityModel>
)