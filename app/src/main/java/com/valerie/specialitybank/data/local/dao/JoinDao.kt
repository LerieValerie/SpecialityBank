package com.valerie.specialitybank.data.local.dao

import androidx.room.*
import com.valerie.specialitybank.data.local.model.SpecialityWorkerJoin

@Dao
interface JoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveJoin(joinList : List<SpecialityWorkerJoin>)
}