package br.com.controller

import br.com.dto.Morador
import br.com.dto.Pesquisa
import br.com.service.MoradorService
import br.com.service.PesquisaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/moradores")
class MoradorController(

    @Autowired
    private val moradorService: MoradorService
) {

    @GetMapping("/")
    fun listaMoradores(): ResponseEntity<List<Morador>> {
        return ResponseEntity.ok<List<Morador>>(moradorService.listaMoradores())
    }
}