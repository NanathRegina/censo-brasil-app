package br.com.service

import br.com.dto.Pesquisa
import br.com.repository.MoradorRepository
import br.com.repository.PesquisaRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
class PesquisaService (
    private val repository: PesquisaRepository,
    private val repositoryMorador: MoradorRepository,
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
            serviceMorador.salvaMoradores(pesquisa.moradores)
            return repository.save(pesquisa)
        }catch (ex: Exception){
            throw ex
        }
    }

    //TODO: caso de uso
    fun apagaPesquisa(idPesquisa: Long) {
        try {
            listaPesquisa(idPesquisa).moradores.forEach {
                morador -> serviceMorador.apagaMorador(morador.id)
            }

            return repository.deleteById(idPesquisa)
        }catch (ex: Exception){
            throw ex
        }
    }



}