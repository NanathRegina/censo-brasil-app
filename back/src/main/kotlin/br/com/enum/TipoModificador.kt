package br.com.enum

enum class TipoModificador(
    val tipo: String?
) {
    SN("SN"),
    FNS("FNS"),
    SMS("SMS"),
    FUNASA("FUNASA"),
    KM("KM")
}