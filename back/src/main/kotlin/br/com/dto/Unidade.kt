package br.com.dto

import br.com.enum.*
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "unidade")
class Unidade (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,


    val identificacao: Boolean = false,

    @field:NotBlank
    val numero: String = "",

    val modificador: TipoModificador,

    val tipoReferencia: TipoReferencia,

    @field:NotBlank
    val referencia: String = "",

    /*
    @OneToMany(mappedBy = "id")
    val complemento: List<Complemento>,
     */

    @field:NotBlank
    val coordenada: String = "",

    val status: Status
    ){

    /*
    @OneToMany(mappedBy = "id")
    val especie: List<Especie>,

     */



}