package com.censobrasilapp.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Complemento(
    var valor: String = "",
    val id: Long? = 0L,
    var elemento: String = ""
)
