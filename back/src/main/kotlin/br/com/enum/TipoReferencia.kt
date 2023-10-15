package br.com.enum

enum class TipoReferencia(
    val tipo: String
) {
    AO_LADO("SN"),
    ANTES_DA("FNS"),
    APOS_A("SMS"),
    EM_FRENTE("FUNASA"),
    EMPTY("")
}