package com.censobrasilapp.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Especie(
    var especieEdificio: String = "EMPTY",
    val id: Long? = 0L,
    var especieDomicilio: String = "EMPTY",
    var telefoneResponsavel: String = "",
    var emailResponsavel: String = "",
    var nomeResponsavel: String = ""
)
