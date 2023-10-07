package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "setor")
class Setor (

    @NotNull
    val nome: String = "",

    @NotNull
    val descricao: String = "",

    @NotNull
    val aglomerado: Boolean = false,

    @NotNull
    val nomeAglomerado: String = "",

    @NotNull
    val pontoInicial: String = "",

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val face: List<Face>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}