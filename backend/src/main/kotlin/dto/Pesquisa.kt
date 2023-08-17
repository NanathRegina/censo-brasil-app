package com.nanathregina.kotlinapplication.dto

import com.nanathregina.kotlinapplication.enum.TipoAbastecimento
import com.nanathregina.kotlinapplication.enum.TipoPesquisa
import org.jetbrains.annotations.NotNull
import java.util.*

class Pesquisa {

    private val id: Long? = null

    @NotNull
    private val tipoPesquisa: TipoPesquisa? = null

    @NotNull
    private val qtdMoradores: String? = null

    @NotNull
    private val qtdCriancas: String? = null

    @NotNull
    private val morador: Morador? = null

    @NotNull
    private val tipoAbastecimento: TipoAbastecimento? = null

    @NotNull
    private val acessoDistribuicao: Boolean? = null

    @NotNull
    private val aguaEncanada: String? = null

    @NotNull
    private val qdtBanheiro: String? = null

    @NotNull
    private val esgoto: String? = null

    @NotNull
    private val lixo: String? = null

    @NotNull
    private val falecimento: Boolean? = null

    @NotNull
    private val dataPesquisa: Date? = null
}