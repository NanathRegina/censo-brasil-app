package com.censobrasilapp.model


import kotlinx.serialization.Serializable

@Serializable
data class Face(
    var quadra: String = "",
    var logradouro: String = "",
    var cep: String = "",
    var bairro: String = "",
    var nar: Boolean = true,
    var dataInclusao: String = "",
    var status: String = "",
    var qtdUnidades: String = "",
    var unidades: List<Unidade>? = listOf(Unidade()),
    val id: Long? = 0L
): java.io.Serializable