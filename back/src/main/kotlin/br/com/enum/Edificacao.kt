package br.com.enum

enum class Edificacao(
    val tipo: String
) {
    CASA("Casa"),
    CASA_VILA("Casa de vila ou condomínio"),
    APARTAMENTO("Apartamento"),
    HABITACAO_INDIGENA("Habitação indígena"),
    HABITACAO_COMODOS("Habitação em casa de cômodos")
}