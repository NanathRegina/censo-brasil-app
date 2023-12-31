package br.com.dto

import br.com.enum.*
import org.jetbrains.annotations.Nullable
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

    val numero: String? = "",

    val modificador: TipoModificador?,

    val tipoReferencia: TipoReferencia?,

    val referencia: String? = "",

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val complemento: List<Complemento>,

    @NotNull
    val coordenada: String = "",

    @NotNull
    val status: Status,

    @NotNull
    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val especie: Especie
    ){
}