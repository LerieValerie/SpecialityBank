package com.valerie.specialitybank.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.valerie.specialitybank.data.local.dao.*
import com.valerie.specialitybank.data.local.model.SpecialityModel
import com.valerie.specialitybank.data.local.model.SpecialityWorkerJoin
import com.valerie.specialitybank.data.local.model.WorkerModel

private const val DB_NAME = "speciality_bank.db"

@Database(
    entities = [
        SpecialityModel::class,
        WorkerModel::class,
        SpecialityWorkerJoin::class
    ],
    version = 1,
    exportSchema = false
)

abstract class SpecialityWorkerDatabase : RoomDatabase() {
    abstract fun joinDao() : JoinDao
    abstract fun specialityDao() : SpecialityDao
    abstract fun workerDao() : WorkerDao

    companion object {
        fun newInstance(context: Context) =
            Room.databaseBuilder(context, SpecialityWorkerDatabase::class.java, DB_NAME).build()
    }
}