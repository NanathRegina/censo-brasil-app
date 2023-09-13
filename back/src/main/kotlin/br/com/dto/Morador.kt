package br.com.dto

import br.com.enum.*
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "morador")
class Morador(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @NotNull
    val nome: String = "",

    @NotNull
    val sobrenome: String = "",

    @NotNull
    val sexo: String = "",

    @NotNull
    val dataNascimento: Date = Date(),

    @NotNull
    val idadeAnos: String = "",

    @NotNull
    val idadeMeses: String = "",

    @NotNull
    val cor: Cor,

    @NotNull
    val leitura: Boolean = false,

    @NotNull
    val formaRenda: Renda,

    @NotNull
    val valor: Double = 0.0,

    @NotNull
    val faixaRendimento: Rendimento,

    @NotNull
    val respondente: String = "",
    ){


}