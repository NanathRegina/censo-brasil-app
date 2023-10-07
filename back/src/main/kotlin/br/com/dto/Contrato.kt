package br.com.dto

import br.com.enum.Abastecimento
import br.com.enum.TipoPesquisa
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "contrato")
class Contrato (

    @NotNull
    val periodoInicial: Date = Date(),

    @NotNull
    val periodoFinal: Date = Date(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}