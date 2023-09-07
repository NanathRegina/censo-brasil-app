package br.com.service

import br.com.dto.Pesquisa
import br.com.repository.PesquisaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Service

@Service
class PesquisaService (
    private val repository: PesquisaRepository
){

    //@Autowired
    //lateinit var pesquisaRepository: PesquisaRepository

//    fun PesquisaService(pesquisaRepository: PesquisaRepository) {
//        this.repository = pesquisaRepository
//    }

    fun iniciar(pesquisa: Pesquisa): String {
        return ""
    }

    fun editar(): String {
        return "gui"
    }

    fun salvar(pesquisa: Pesquisa): String {
        return ""
    }

    fun finalizar(pesquisa: Pesquisa): String {
        return ""
    }

    fun excluir(pesquisa: Pesquisa): String {
        return ""
    }

    fun listarPesquisas():Long {
        try{
        return repository.count()
        } catch (ex: Exception){
            println("erro")
        }
        return 0
    }

    /*
    fun listarPesquisa(pesquisa: Pesquisa): Pesquisa {
        return ""
    }
    */

    fun agendar(pesquisa: Pesquisa): String {
        return ""
    }
}