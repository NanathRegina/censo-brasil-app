package br.com.enum

enum class Abastecimento(
    val tipo: String
) {
    REDE_GERAL("Rede geral de distribuição"),
    POCO("Poço"),
    CARRO_PIPA("Carro-pipa"),
    CHUVA("Água da chuva armazenada")
}