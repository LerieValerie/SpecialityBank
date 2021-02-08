package com.valerie.specialitybank.data.local.store

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.valerie.specialitybank.data.local.model.SpecialityModel
import com.valerie.specialitybank.data.local.model.SpecialityWorkerJoin
import com.valerie.specialitybank.data.local.model.WorkerModel

data class WorkerSpecialityStore(
    @Embedded
        val worker: WorkerModel,
    @Relation(
                parentColumn = "workerId",
//                entity = SpecialityModel::class,
                entityColumn = "specialityId",
                associateBy = Junction(
                    SpecialityWorkerJoin::class,
            parentColumn = "workerId",
            entityColumn = "specialityId"
                )
        )

        val specialityList: List<SpecialityModel>
)