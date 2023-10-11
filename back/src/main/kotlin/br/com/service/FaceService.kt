package br.com.service

import br.com.dto.Face
import br.com.dto.Pesquisa
import br.com.repository.FaceRepository
import br.com.repository.MoradorRepository
//import br.com.repository.PesquisaRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
class FaceService (
    private val repository: FaceRepository,
    private val serviceUnidade: UnidadeService
){

    fun listaFace(idFace: Long): Face {
        //TODO: tratar exception de face n encontrada
        try {
            return repository.findById(idFace).get()
        }catch (ex: Exception){
            throw ex
        }
    }

    fun listaFaces(): List<Face> {

        var listaFaces :List<Face>
        try {
            listaFaces = repository.findAll().toList()
            listaFaces.forEach{face ->
                face.qtdUnidades= face.unidades.count().toString()
            }
            return listaFaces
        }catch (ex: Exception){
            throw ex
        }
    }

    //TODO: caso de uso
    fun criaFace(face: Face): Face {
        try {
            return repository.save(face)
        }catch (ex: Exception){
            throw ex
        }
    }

    fun apagaFace(idFace: Long) {
        //TODO: tratar exception de face n encontrada
        try {
            listaFace(idFace).unidades.forEach{
                unidade -> serviceUnidade.apagaUnidade(unidade.id)
            }

            return repository.deleteById(idFace)
        }catch (ex: Exception){
            throw ex
        }
    }

}