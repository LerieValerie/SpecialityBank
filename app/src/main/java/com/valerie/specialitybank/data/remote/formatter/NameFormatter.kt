package com.valerie.specialitybank.data.remote.formatter

class NameFormatter {
    companion object {
        fun String.toUpStart() =
            this.substring(0, 1).toUpperCase() + this.substring(1).toLowerCase()
    }
}