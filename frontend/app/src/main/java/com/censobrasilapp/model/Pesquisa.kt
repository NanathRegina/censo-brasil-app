package com.censobrasilapp.model



import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Pesquisa(
    //val tipoPesquisa: TipoPesquisa,
    var tipoPesquisa: String = "",
    var qtdMoradores: String = "",
    var qtdCriancas: String = "",
    var moradores: List<Morador>? = listOf(Morador()),
    //val tipoAbastecimento: Abastecimento,
    val tipoAbastecimento: String = "",
    val acessoDistribuicao: Boolean = true,
    val aguaEncanada: String = "",
    val qtdBanheiro: String = "",
    val esgoto: String = "",
    val lixo: String = "",
    val falecimento: Boolean = false,
    val dataPesquisa: String = "",
    val idPesquisa: Long? = 0L
): java.io.Serializable