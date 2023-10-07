package br.com.dto

import br.com.enum.*
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "face")
class Face(

    @NotNull
    val quadra: String = "",

    @NotNull
    val logradouro: String = "",

    @NotNull
    val cep: String = "",

    @NotNull
    val bairro: String = "",

    @NotNull
    val nar: Boolean = false,

    @NotNull
    val dataInclusao: Date = Date(),

    @NotNull
    val status: StatusFace,

    @NotNull
    val qtdUnidades: String = "",

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val unidade: List<Unidade>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}