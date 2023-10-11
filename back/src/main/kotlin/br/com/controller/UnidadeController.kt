package br.com.controller

import br.com.dto.Face
import br.com.dto.Unidade
import br.com.service.FaceService
import br.com.service.UnidadeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/unidades")
class UnidadeController(

    @Autowired
    private val unidadeService: UnidadeService
) {
    //TODO: validação de contrato não está funcionando

    @GetMapping("/")
    fun listaUnidades(): ResponseEntity<List<Unidade>> {
        return ResponseEntity.ok<List<Unidade>>(unidadeService.listaUnidades())
    }

    @GetMapping("/{idUnidade}")
    fun listaUnidade(@PathVariable idUnidade: Long): ResponseEntity<Unidade> {
        return ResponseEntity.ok<Unidade>(unidadeService.listaUnidade(idUnidade))
    }

    @PostMapping("/unidade")
    fun criaUnidade(@RequestBody @Valid unidade: Unidade): Unidade {
        println(unidade.toString())
        return unidadeService.criaUnidade(unidade)
    }
}