package com.censobrasilapp.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Morador(
    var nome: String = "",
    var sobrenome: String = "",
    var sexo: String = "",
    @Contextual
    var dataNascimento: String = "",
    val idadeAnos: String = "",
    val idadeMeses: String = "",
    var cor: String = "",
    var formaRenda: String = "",
    val valor: Double = 0.0,
    var faixaRendimento: String = "",
    val respondente: String = "",
    val idMorador: Long? = 0L,
    var leitura: Boolean = true,
)
