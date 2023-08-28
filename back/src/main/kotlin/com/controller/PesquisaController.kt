package com.controller

import com.service.PesquisaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/pesquisas")
class PesquisaController {

    @Autowired
    lateinit var pesquisaService: PesquisaService

    fun PesquisaController(pesquisaService: PesquisaService) {
        this.pesquisaService = pesquisaService
    }

    @GetMapping("/")
    fun pesquisas(): Long {
        return pesquisaService.listarPesquisas()
    }
}