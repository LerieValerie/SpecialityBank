package com.valerie.specialitybank.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SpecialityWorkerDao {
    @Transaction
    @Query("SELECT * FROM speciality")
    fun loadSpeciality(): Flow<List<SpecialityModel>>

//    @Transaction
//    @Query("SELECT * FROM speciality")
//    fun loadSpecialityJoin(): Flow<List<SpecialityWorkerStore>>

    @Transaction
    @Query("SELECT * FROM speciality")
    suspend fun loadSpecialityListForCheck(): List<SpecialityModel>

    @Transaction
    @Query("SELECT * FROM speciality WHERE specialityId = :specialityId")
    fun loadSpecialityById(specialityId : Int): Flow<SpecialityModel>

//    @Transaction
//    @Query("SELECT * FROM worker")
//    abstract suspend fun loadWorkerJoin(): Flow<List<WorkerSpecialityStore>>

    @Transaction
    @Query("SELECT * FROM speciality WHERE specialityId = :specialityId")
    fun loadWorkerListBySpecialityId(specialityId : Int): Flow<SpecialityWorkerStore>

//    @Transaction
//    @Query("SELECT * FROM worker WHERE workerId = :workerId")
//    abstract suspend fun loadSpecialityByWorker(workerId : String): WorkerSpecialityStore
}
