package br.com.enum

enum class TipoPesquisa(
    val tipo: String
) {
    PRESENCIAL("Presencial"),
    AGENDADA("Agendada"),
    INTERNET("Via internet"),
    NAO_REALIZADA("Não realizada")
}