package br.com.controller

import br.com.service.PesquisaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/pesquisas")
class PesquisaController(

    @Autowired
    private val pesquisaService: PesquisaService
) {

//
//    @GetMapping("/teste1")
//    fun pesquisas(): Long {
//        return pesquisaService.listarPesquisas()
//    }

    @GetMapping("/teste")
    fun teste(): Long{
        return pesquisaService.listarPesquisas()
    }
}