package com.valerie.specialitybank.data.local.dao

import androidx.room.*
import com.valerie.specialitybank.data.local.model.WorkerModel
import com.valerie.specialitybank.data.local.store.WorkerSpecialityStore
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkerDao {

    @Transaction
    @Query("SELECT * FROM worker WHERE workerId = :workerId")
    fun loadWorkerById(workerId: Int): Flow<WorkerModel?>

    @Transaction
    @Query("SELECT * FROM worker WHERE workerId = :workerId")
    fun loadSpecialityListByWorkerId(workerId: Int): Flow<WorkerSpecialityStore?>

    @Query("DELETE FROM worker")
    suspend fun deleteAllWorker()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWorker(workerList: List<WorkerModel>)
}