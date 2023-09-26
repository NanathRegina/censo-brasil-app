package com.censobrasilapp.model

import java.util.Date

data class Pesquisa(
    //val tipoPesquisa: TipoPesquisa,
    val tipoPesquisa: String,
    val qtdMoradores: String,
    val qtdCriancas: String,
    val moradores: List<Morador>?,
    //val tipoAbastecimento: Abastecimento,
    val tipoAbastecimento: String,
    val acessoDistribuicao: Boolean,
    val aguaEncanada: String,
    val qtdBanheiro: String,
    val esgoto: String,
    val lixo: String,
    val falecimento: Boolean,
    val dataPesquisa: String,
    val idPesquisa: Long?
)