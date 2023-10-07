package br.com.dto

import br.com.enum.*
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "funcionario")
class Funcionario(

    @NotNull
    val nome: String = "",

    @NotNull
    val email: String = "",

    @NotNull
    val sexo: String = "",

    @NotNull
    val uf: String = "",

    @NotNull
    val responsavel: String = "",

    @NotNull
    val endereco: String = "",

    @NotNull
    val telefone: String = "",

    @NotNull
    val status: String = "",

    @NotNull
    val login: String = "",

    @NotNull
    val senha: String = "",

    @NotNull
    val funcao: Funcao,

    @NotNull
    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val patrimonio: Patrimonio,

    @NotNull
    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val contrato: Contrato,

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val pesquisa: List<Pesquisa>,

    @NotNull
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val setor: List<Setor>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
    ){


}