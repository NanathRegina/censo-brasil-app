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
    // val cor: Cor,
    //val formaRenda: Renda,
    val cor: String = "",
    val formaRenda: String = "",
    val valor: Double = 0.0,
    //val faixaRendimento: Rendimento,
    val faixaRendimento: String = "",
    val respondente: String = "",
    val idMorador: Long? = 0L
)
