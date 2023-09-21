package br.com.service

import br.com.dto.Morador
import br.com.repository.MoradorRepository
import org.springframework.stereotype.Service

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

    fun salvaMorador(morador: Morador): Morador {
        try {
            return repository.save(morador)
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