package com.censobrasilapp.model

import java.util.Date

data class Pesquisa(
    //val tipoPesquisa: TipoPesquisa,
    val qtdMoradores: String,
    val qtdCriancas: String,
    val moradores: List<Morador>,
    //val tipoAbastecimento: Abastecimento,
    val acessoDistribuicao: Boolean,
    val aguaEncanada: String,
    val qtdBanheiro: String,
    val esgoto: String,
    val lixo: String,
    val falecimento: Boolean,
    val dataPesquisa: Date,
    val idPesquisa: Long
)