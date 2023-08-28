package com.dto

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pesquisa")
class Pesquisa {

    @Id
    @GeneratedValue
    private val id: Long? = null

    @NotNull
    private val qtdMoradores: String? = null

    @NotNull
    private val qtdCriancas: String? = null

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