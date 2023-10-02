package com.censobrasilapp.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Unidade(
    val status: String = "",
    val coordenada: String = "",
    var referencia: String = "",
    var tipoReferencia: String = "",
    var modificador: String = "",
    val numero: String = "",
    val id: Long? = 0L,
    var identificacao: Boolean = true,
)
