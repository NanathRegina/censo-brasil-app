package com.service

import com.dto.Pesquisa
import com.repository.PesquisaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
public class PesquisaService {

    @Autowired
    lateinit var pesquisaRepository: PesquisaRepository

    fun PesquisaService(pesquisaRepository: PesquisaRepository) {
        this.pesquisaRepository = pesquisaRepository
    }

    fun iniciar(pesquisa: Pesquisa): String {
        return ""
    }

    fun editar(pesquisa: Pesquisa): String {
        return ""
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
        return pesquisaRepository.count()
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