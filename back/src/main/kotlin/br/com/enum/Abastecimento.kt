package br.com.enum

enum class Abastecimento(
    val tipo: String
) {
    REDE_GERAL("Rede geral"),
    POCO("Poço"),
    CARRO_PIPA("Carro pipa"),
    CHUVA("Chuva")
}