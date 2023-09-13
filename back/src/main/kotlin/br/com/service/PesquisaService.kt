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
    private val repositoryMorador: MoradorRepository
){

    fun listaPesquisa(idPesquisa: Long): Pesquisa {
        var pesquisa: Pesquisa
            try {
                pesquisa = repository.findById(idPesquisa).get()
            }catch (ex: Exception){
                throw ex
            }
                return pesquisa
    }

    fun listaPesquisas(): List<Pesquisa> {
        var pesquisa: List<Pesquisa>
        try {
            pesquisa = repository.findAll().toList()
        }catch (ex: Exception){
            throw ex
        }
        return pesquisa
    }

    fun salvaPesquisa(pesquisa: Pesquisa): Pesquisa {
        try {
            //TODO: chamar a service aqui, ao invés da repository
            repositoryMorador.saveAll(pesquisa.moradores)
            return repository.save(pesquisa)
        }catch (ex: Exception){
            throw ex
        }
    }



}