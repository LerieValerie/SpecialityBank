package com.valerie.specialitybank.data.remote

import com.google.gson.annotations.SerializedName
import com.valerie.specialitybank.data.remote.transformation.DateTransform.Companion.toKotlinInstant
import com.valerie.specialitybank.data.remote.transformation.NameTransform.Companion.toUpStart
import com.valerie.specialitybank.domain.entity.Worker

data class WorkerResponse(
    @SerializedName("f_name") val name: String?,
    @SerializedName("l_name") val surname: String?,
    @SerializedName("birthday") val birthDate: String?,
    @SerializedName("avatr_url") val imageUrl: String?,
    @SerializedName("specialty") val specialityResponseList: List<SpecialityResponse> = listOf()
) {
    fun toEntity(id: Int) = Worker(
        id = id,
        name = name?.toUpStart(),
        surname = surname?.toUpStart(),
        birthDate = birthDate?.toKotlinInstant(),
        imageUrl = imageUrl,
        specialityIdList = specialityResponseList.map { it.id }
    )
}