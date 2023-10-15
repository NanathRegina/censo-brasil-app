package com.censobrasilapp.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Unidade(
    val status: String = "EMPTY",
    var coordenada: String = "",
    var referencia: String = "",
    var tipoReferencia: String = "EMPTY",
    var modificador: String = "EMPTY",
    var numero: String = "",
    val id: Long? = 0L,
    var identificacao: Boolean = true,
    var complemento: List<Complemento>? = listOf(Complemento()),
    var especie: Especie? = Especie()
)
