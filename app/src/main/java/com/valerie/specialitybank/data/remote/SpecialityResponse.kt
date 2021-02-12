package com.valerie.specialitybank.data.remote

import com.google.gson.annotations.SerializedName
import com.valerie.specialitybank.domain.entity.Speciality

data class SpecialityResponse(
    @SerializedName("specialty_id") val id: Int,
    @SerializedName("name") val name: String?
) {
    fun toEntity() = Speciality(
        id = id,
        name = name
    )
}
