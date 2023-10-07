package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "patrimonio")
class Patrimonio (

    @NotNull
    val nome: String = "",

    @NotNull
    val tipo: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}