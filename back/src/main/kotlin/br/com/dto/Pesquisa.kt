package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "pesquisa")
class Pesquisa (

    @NotNull
    val tipoPesquisa: TipoPesquisa,

    @NotNull
    val qtdMoradores: String = "",

    //@field:NotBlank
    @NotNull
    val qtdCriancas: String = "",

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val moradores: List<Morador>,

    @NotNull
    val tipoAbastecimento: Abastecimento,

    @NotNull
    val acessoDistribuicao: Boolean = false,

    @NotNull
    val aguaEncanada: String = "",

    @NotNull
    val qtdBanheiro: String = "",

    @NotNull
    val esgoto: String = "",

    @NotNull
    val lixo: String = "",

    @NotNull
    val falecimento: Boolean = false,

    @NotNull
    val dataPesquisa: Date = Date(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPesquisa: Long = 0L
    ){


}