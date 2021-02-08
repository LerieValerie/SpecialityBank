package com.valerie.specialitybank.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import com.valerie.specialitybank.data.local.model.SpecialityModel
import com.valerie.specialitybank.data.local.model.WorkerModel

@Entity(
        tableName = "speciality_worker_join",
        primaryKeys = ["specialityId", "workerId"],
        indices = [Index("specialityId"), Index("workerId")],
        foreignKeys = [
            ForeignKey(
                    entity = SpecialityModel::class,
                    parentColumns = ["specialityId"],
                    childColumns = ["specialityId"],
                    onDelete = CASCADE
            ),
            ForeignKey(
                    entity = WorkerModel::class,
                    parentColumns = ["workerId"],
                    childColumns = ["workerId"],
                    onDelete = CASCADE
            )
        ]
)
data class SpecialityWorkerJoin(
        val specialityId: Int,
        val workerId: Int
)