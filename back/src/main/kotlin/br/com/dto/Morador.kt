package br.com.dto

import br.com.enum.*
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "morador")
class Morador(


    //@NotNull
    val nome: String = "",

    //@NotNull
    val sobrenome: String = "",

    //@NotNull
    val sexo: String = "",

    //@NotNull
    val dataNascimento: Date = Date(),

    //@NotNull
    val idadeAnos: String = "",

    //@NotNull
    val idadeMeses: String = "",

    //@NotNull
    val cor: Cor,

    //@NotNull
    val leitura: Boolean = false,

    //@NotNull
    val formaRenda: Renda,

    //@NotNull
    val valor: Double = 0.0,

    //@NotNull
    val faixaRendimento: Rendimento,

    //@NotNull
    val respondente: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMorador: Long = 0L
    ){


}