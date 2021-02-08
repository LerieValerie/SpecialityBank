package com.valerie.specialitybank.data.local

import androidx.room.*

@Dao
interface GeneralDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSpeciality(specialityList : List<SpecialityModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWorker(workerList : List<WorkerModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveJoin(join : SpecialityWorkerJoin)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(joinList : List<SpecialityWorkerJoin>)

    @Transaction
    suspend fun saveAll(specialityList : List<SpecialityModel>, workerList : List<WorkerModel>, joinList : List<SpecialityWorkerJoin>) {
        saveSpeciality(specialityList)
        saveWorker(workerList)
        saveAll(joinList)
    }

    @Query("DELETE FROM worker")
    suspend fun deleteAllWorker()

    @Query("DELETE FROM speciality")
    suspend fun deleteAllSpeciality()

    @Query("DELETE FROM speciality_worker_join")
    suspend fun deleteAllJoin()

    suspend fun deleteAll() {
        deleteAllWorker()
        deleteAllSpeciality()
        deleteAllJoin()
    }
}