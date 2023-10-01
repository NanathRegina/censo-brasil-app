package br.com.dto

import br.com.enum.*
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "morador")
class Morador(


    @NotNull
    val nome: String = "",

    @NotNull
    val sobrenome: String = "",

    @NotNull
    val sexo: String = "",

    //@NotNull
    //TODO: pode ser nulo
    val dataNascimento: Date? = Date(),

    //@NotNull
    //TODO: pode ser nulo
    val idadeAnos: String? = "",

    //@NotNull
    val idadeMeses: String? = "",

    @NotNull
    val cor: Cor,

    @NotNull
    val leitura: Boolean = false,

    @NotNull
    val formaRenda: Renda,

    //@NotNull
    //TODO: pode ser nulo
    val valor: Double? = 0.0,

    //@NotNull
    //TODO: pode ser nulo
    val faixaRendimento: Rendimento?,

    //@NotNull
    //TODO: pode ser nulo
    val respondente: String? = "",

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMorador: Long = 0L
    ){


}