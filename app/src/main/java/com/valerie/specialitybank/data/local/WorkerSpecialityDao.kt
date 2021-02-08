package com.valerie.specialitybank.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkerSpecialityDao {

    @Transaction
    @Query("SELECT * FROM worker WHERE workerId = :workerId")
    fun loadWorkerById(workerId : Int): Flow<WorkerModel>

    @Transaction
    @Query("SELECT * FROM worker WHERE workerId = :workerId")
    fun loadSpecialityListByWorkerId(workerId: Int): Flow<WorkerSpecialityStore>
}