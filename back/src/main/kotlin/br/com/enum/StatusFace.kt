package br.com.enum

enum class StatusFace(
    val tipo: String
) {
    NAO_INICIADO("Não iniciado"),
    EM_ANDAMENTO("Em andamento"),
    PAUSADO("Pausado"),
    FINALIZADO("Finalizado")
}