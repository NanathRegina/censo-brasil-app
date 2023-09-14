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

    fun listaMorador(idMorador: Long): Morador {
        //TODO: tratar exception de morador n encontrado
        try {
            return repository.findById(idMorador).get()
        }catch (ex: Exception){
            throw ex
        }
    }
    fun listaMoradores(): List<Morador> {
        try {
            return repository.findAll().toList()
        }catch (ex: Exception){
            throw ex
        }
    }

    fun salvaMoradores(moradores: List<Morador>): List<Morador> {
        try {
            return repository.saveAll(moradores).toList()
        }catch (ex: Exception){
            throw ex
        }
    }

    fun apagaMorador(idMorador: Long){
        try {
            return repository.deleteById(idMorador)
        }catch (ex: Exception){
            throw ex
        }
    }



}