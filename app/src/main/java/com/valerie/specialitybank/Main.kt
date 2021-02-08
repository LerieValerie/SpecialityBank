package com.valerie.specialitybank

import kotlinx.datetime.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


//import java.text.SimpleDateFormat

fun main(args: Array<String>) {
//    runBlocking {
//        val controller = RetrofitBuilder.buildApi("http://gitlab.65apps.com/65gb/static/raw/master/")
//        val net = controller.getWorker()
//        val  b = net.workerResponseList?.isEmpty()
//    }

    val a = getAge()
    TODO()


}

private val formatter = DateTimeFormatter.ofPattern(
    "[yyyy-MM-dd]" +
            "[dd-MM-yyyy]"
)

private fun String.toKotlinInstant() =
    if (!isNullOrEmpty()) {
        val localDate = LocalDate.parse(this, formatter).toKotlinLocalDate()
        localDate.atStartOfDayIn(TimeZone.currentSystemDefault())
    }
    else {
        null
    }

fun getAge() : Int {

//    val birthDate : String = "23-07-2000"
    val birthDate2 : String = "1987-03-23"

    var age = 0

//    val first = birthDate.toKotlinInstant()
    val second = birthDate2.toKotlinInstant()

    val currentDate = Clock.System.now()

    if (second != null) {
//        age = first.yearsUntil(currentDate, TimeZone.currentSystemDefault())
        val age2 = second?.yearsUntil(currentDate, TimeZone.currentSystemDefault())
        println()
    }

    println()



//    fun fromJson(dateString: String): LocalDate? =
//        if (dateString.isNotEmpty())
//            LocalDate.parse(dateString, formatter)
//        else
//            null



    return age
}

//private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
//        .withLocale(Locale.US)
//        .withZone(ZoneId.systemDefault())
//
//private val dateTimeFormatter2: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
//        .withLocale(Locale.US)
//        .withZone(ZoneId.systemDefault())