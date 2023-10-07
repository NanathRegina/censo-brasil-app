package br.com.dto

import br.com.enum.*
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "complemento")
class Complemento(

    @NotNull
    val elemento: String? = "",

    @NotNull
    val valor: String? = "",

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}