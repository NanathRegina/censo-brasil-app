package br.com.dto

import br.com.enum.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

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