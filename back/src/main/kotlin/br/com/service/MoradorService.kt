package br.com.service

import br.com.dto.Morador
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
class MoradorService (
    private val repository: MoradorRepository
){

    fun listaMoradores(): List<Morador> {
        var morador: List<Morador>
        try {
            morador = repository.findAll().toList()
        }catch (ex: Exception){
            throw ex
        }
        return morador
    }

    fun salvaMorador(morador: Morador): Morador {
        try {
            return repository.save(morador)
        }catch (ex: Exception){
            throw ex
        }
    }



}