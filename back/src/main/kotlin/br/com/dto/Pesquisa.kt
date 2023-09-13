package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "pesquisa")
class Pesquisa (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,


    val tipoPesquisa: TipoPesquisa,

    @field:NotBlank
    val qtdMoradores: String = "",

    @field:NotBlank
    val qtdCriancas: String = "",

    @OneToMany(mappedBy = "id")
    val moradores: List<Morador>,


    val tipoAbastecimento: Abastecimento,


    val acessoDistribuicao: Boolean = false,

    @field:NotBlank
    val aguaEncanada: String = "",

    @field:NotBlank
    val qtdBanheiro: String = "",

    @field:NotBlank
    val esgoto: String = "",

    @field:NotBlank
    val lixo: String = "",


    val falecimento: Boolean = false,


    val dataPesquisa: Date = Date(),
    ){


}