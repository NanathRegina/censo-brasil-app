package br.com.dto

import br.com.enum.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "unidade")
class Unidade (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @NotNull
    val identificacao: Boolean = false,

    //@field:NotBlank
    //TODO: pode ser nulo
    val numero: String? = "",

    //TODO: pode ser nulo
    val modificador: TipoModificador?,

    //TODO: pode ser nulo
    val tipoReferencia: TipoReferencia?,

    //TODO: pode ser nulo
    val referencia: String? = "",

    //TODO: falta complemento
    /*
    @OneToMany(mappedBy = "id")
    val complemento: List<Complemento>,
     */

    @NotNull
    val coordenada: String = "",

    @NotNull
    val status: Status
    ){

    /*
    @OneToMany(mappedBy = "id")
    val especie: List<Especie>,

     */



}