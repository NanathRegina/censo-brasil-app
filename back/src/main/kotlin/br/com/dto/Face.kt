package br.com.dto

import br.com.enum.*
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "face")
class Face(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

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
    @OneToMany(mappedBy = "id")
    val unidades: List<Unidade>,
    ){


}