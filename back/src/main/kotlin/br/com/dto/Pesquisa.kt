package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pesquisa")
class Pesquisa (


    val tipoPesquisa: TipoPesquisa,

    //@field:NotBlank
    val qtdMoradores: String = "",

    //@field:NotBlank
    val qtdCriancas: String = "",

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val moradores: List<Morador>,

    val tipoAbastecimento: Abastecimento,

    val acessoDistribuicao: Boolean = false,

    //@field:NotBlank
    val aguaEncanada: String = "",

    //@field:NotBlank
    val qtdBanheiro: String = "",

    //@field:NotBlank
    val esgoto: String = "",

    //@field:NotBlank
    val lixo: String = "",

    val falecimento: Boolean = false,

    val dataPesquisa: Date = Date(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPesquisa: Long = 0L
    ){


}