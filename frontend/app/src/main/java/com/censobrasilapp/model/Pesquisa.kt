package com.censobrasilapp.model



import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Pesquisa(
    var tipoPesquisa: String = "",
    var qtdMoradores: String = "",
    var qtdCriancas: String = "",
    var moradores: List<Morador>? = listOf(Morador()),
    var tipoAbastecimento: String = "",
    var acessoDistribuicao: Boolean = true,
    var aguaEncanada: String = "",
    var qtdBanheiro: String = "",
    var esgoto: String = "",
    var lixo: String = "",
    var falecimento: Boolean = false,
    @Contextual
    var dataPesquisa: String = "",
    val idPesquisa: Long? = 0L
): java.io.Serializable