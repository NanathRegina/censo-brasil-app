package br.com.enum

enum class Status(
    val tipo: String
) {
    NAO_INICIADO("Não iniciado"),
    EM_ANDAMENTO("Em andamento"),
    PENDENTE("Pendente"),
    FINALIZADO("Finalizado")
}