package com.censobrasilapp.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Morador(
    val nome: String,
    val sobrenome: String,
    val sexo: String,
    @Contextual
    val dataNascimento: String,
    val idadeAnos: String,
    val idadeMeses: String,
    // val cor: Cor,
    //val formaRenda: Renda,
    val cor: String,
    val formaRenda: String,
    val valor: Double,
    //val faixaRendimento: Rendimento,
    val faixaRendimento: String,
    val respondente: String,
    val idMorador: Long?
)
