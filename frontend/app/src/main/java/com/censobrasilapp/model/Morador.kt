package com.censobrasilapp.model

import java.util.Date

data class Morador(
    val nome: String,
    val sobrenome: String,
    val sexo: String,
    val dataNascimento: Date,
    val idadeAnos: String,
    val idadeMeses: String,
    // val cor: Cor,
    //val formaRenda: Renda,
    val valor: Double,
    //val faixaRendimento: Rendimento,
    val respondente: String,
    val idMorador: Long
)
