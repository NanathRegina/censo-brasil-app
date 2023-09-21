package br.com.service

import br.com.dto.Pesquisa
import br.com.repository.PesquisaRepository
import org.springframework.stereotype.Service

@Service
class PesquisaService (
    private val repository: PesquisaRepository,
    private val serviceMorador: MoradorService
){
        fun listaPesquisa(idPesquisa: Long): Pesquisa {
            //TODO: tratar exception de pesquisa n encontrada
                try {
                    return repository.findById(idPesquisa).get()
                }catch (ex: Exception){
                    throw ex
                }
        }

        fun listaPesquisas(): List<Pesquisa> {
            try {
                return repository.findAll().toList()
            }catch (ex: Exception){
                throw ex
            }
        }

        //TODO: caso de uso
        fun salvaPesquisa(pesquisa: Pesquisa): Pesquisa {
            try {
                return repository.save(pesquisa)
            }catch (ex: Exception){
                throw ex
            }
        }

        //TODO: caso de uso
        fun apagaPesquisa(idPesquisa: Long) {
            try {
                listaPesquisa(idPesquisa).moradores.forEach {
                    morador -> serviceMorador.apagaMorador(morador.idMorador)
                }

                return repository.deleteById(idPesquisa)
            }catch (ex: Exception){
                throw ex
            }
        }


}