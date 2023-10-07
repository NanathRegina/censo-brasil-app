package br.com.dto

import br.com.enum.*
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "especie")
class Especie(

    @NotNull
    val nomeResponsavel: String? = "",

    @NotNull
    val telefoneResponsavel: String? = "",

    @NotNull
    val emailResponsavel: String? = "",

    @NotNull
    val especieDomicilio: Domicilio,

    @NotNull
    val especieEdificio: Edificacao,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}