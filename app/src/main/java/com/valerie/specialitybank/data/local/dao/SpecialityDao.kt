package com.valerie.specialitybank.data.local.dao

import androidx.room.*
import com.valerie.specialitybank.data.local.model.SpecialityModel
import com.valerie.specialitybank.data.local.store.SpecialityWorkerStore
import kotlinx.coroutines.flow.Flow

@Dao
interface SpecialityDao {
    @Transaction
    @Query("SELECT * FROM speciality")
    fun loadSpeciality(): Flow<List<SpecialityModel>>

    @Transaction
    @Query("SELECT * FROM speciality")
    suspend fun loadSpecialityListForCheck(): List<SpecialityModel>

    @Transaction
    @Query("SELECT * FROM speciality WHERE specialityId = :specialityId")
    fun loadSpecialityById(specialityId : Int): Flow<SpecialityModel?>

    @Transaction
    @Query("SELECT * FROM speciality WHERE specialityId = :specialityId")
    fun loadWorkerListBySpecialityId(specialityId : Int): Flow<SpecialityWorkerStore?>

    @Query("DELETE FROM speciality")
    suspend fun deleteAllSpeciality()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSpeciality(specialityList : List<SpecialityModel>)
}
