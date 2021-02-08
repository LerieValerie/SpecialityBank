package com.valerie.specialitybank.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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
//@TypeConverters(TypeTransmogrifier::class)

abstract class SpecialityWorkerDatabase : RoomDatabase() {
    abstract fun generalDao() : GeneralDao
    abstract fun specialityWorkerDao() : SpecialityWorkerDao
    abstract fun workerSpecialityDao() : WorkerSpecialityDao

    companion object {
        fun newInstance(context: Context) =
            Room.databaseBuilder(context, SpecialityWorkerDatabase::class.java, DB_NAME).build()
    }

//    private suspend fun populateDatabase(api: NetInterface, generalDao: GeneralDao) {
////        val api = RetrofitBuilder.buildApi("http://gitlab.65apps.com/65gb/static/raw/master/")
//        val workerRootResponse = api.getWorker()
//
//        val workerList = workerRootResponse.toWorkerList()
//        val specialityList = workerRootResponse.toSpecialityList()
//
//        val specialityModelList = specialityList.toSpecialityModelList()
//        val workerModelList = workerList.toWorkerModelList()
//        val joinList = toSpecialityWorkerJoinList(workerList, specialityList)
//
//        generalDao.saveAll(specialityList = specialityModelList, workerList = workerModelList, joinList = joinList)
//    }
}