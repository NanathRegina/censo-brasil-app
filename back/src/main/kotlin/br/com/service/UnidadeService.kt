package br.com.service

import br.com.dto.Face
import br.com.dto.Pesquisa
import br.com.dto.Unidade
import br.com.repository.FaceRepository
import br.com.repository.MoradorRepository
import br.com.repository.UnidadeRepository
//import br.com.repository.PesquisaRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
class UnidadeService (
    private val repository: UnidadeRepository
){

    fun listaUnidade(idUnidade: Long): Unidade {
        //TODO: tratar exception de face n encontrada
        try {
            return repository.findById(idUnidade).get()
        }catch (ex: Exception){
            throw ex
        }
    }

    fun listaUnidades(): List<Unidade> {

        var listaUnidades :List<Unidade>
        try {
            return repository.findAll().toList()

        }catch (ex: Exception){
            throw ex
        }
    }

    //TODO: caso de uso
    fun criaUnidade(unidade: Unidade): Unidade {
        try {
            return repository.save(unidade)
        }catch (ex: Exception){
            throw ex
        }
    }

}