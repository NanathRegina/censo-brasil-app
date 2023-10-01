package com.censobrasilapp.api

import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.util.Date

@Serializable
data class PesquisaResponse(
    val tipoPesquisa: String,
    val qtdMoradores: String,
    val qtdCriancas: String,
    @Contextual
    val moradores: List<Morador>,
    val tipoAbastecimento: String,
    val acessoDistribuicao: Boolean,
    val aguaEncanada: String,
    val qtdBanheiro: String,
    val esgoto: String,
    val lixo: String,
    val falecimento: Boolean,
    @Contextual
    val dataPesquisa: String,
    val idPesquisa: Long?
)

fun PesquisaResponse.toPesquisa() = Pesquisa(
    idPesquisa = idPesquisa,
    falecimento = falecimento,
    lixo = lixo,
    esgoto = esgoto,
    qtdBanheiro = qtdBanheiro,
    qtdCriancas = qtdCriancas,
    qtdMoradores = qtdMoradores,
    acessoDistribuicao = acessoDistribuicao,
    aguaEncanada = aguaEncanada,
    dataPesquisa = dataPesquisa,
    moradores = listOf(),
    tipoAbastecimento = tipoAbastecimento,
    tipoPesquisa = tipoPesquisa

)