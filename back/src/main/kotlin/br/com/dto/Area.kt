package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "area")
class Area (

    @NotNull
    val nome: String = "",

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val postoColeta: List<PostoColeta>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}