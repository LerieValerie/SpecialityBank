package com.valerie.specialitybank.domain.entity

data class Failure(override val message: String? = null, override val cause: Throwable? = null) :
    Throwable(message, cause)