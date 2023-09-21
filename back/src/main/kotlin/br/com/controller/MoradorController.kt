package br.com.controller

import br.com.dto.Morador
import br.com.service.MoradorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/moradores")
class MoradorController(

    //TODO: validacção de contrato não está funcionando
    @Autowired
    private val moradorService: MoradorService
) {

    @GetMapping("/")
    fun listaMoradores(): ResponseEntity<List<Morador>> {
        return ResponseEntity.ok<List<Morador>>(moradorService.listaMoradores())
    }

    @GetMapping("/{idMorador}")
    fun listaMorador(@PathVariable idMorador: Long): ResponseEntity<Morador> {
        return ResponseEntity.ok<Morador>(moradorService.listaMorador(idMorador))
    }

    @PostMapping("/morador")
    fun salvarMorador(@RequestBody @Valid morador: Morador): Morador {
        return moradorService.salvaMorador(morador)
    }
}