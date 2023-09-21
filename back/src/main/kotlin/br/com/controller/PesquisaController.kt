package br.com.controller

import br.com.dto.Pesquisa
import br.com.service.PesquisaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/pesquisas")
class PesquisaController(

    //TODO: validacção de contrato não está funcionando
    @Autowired
    private val pesquisaService: PesquisaService
) {
        @GetMapping("/")
        fun listaPesquisas(): ResponseEntity<List<Pesquisa>> {
            return ResponseEntity.ok<List<Pesquisa>>(pesquisaService.listaPesquisas())
        }

        @GetMapping("/{idPesquisa}")
        fun listaPesquisa(@PathVariable idPesquisa: Long): ResponseEntity<Pesquisa> {
            return ResponseEntity.ok<Pesquisa>(pesquisaService.listaPesquisa(idPesquisa))
        }


        @PostMapping("/pesquisa")
        fun salvarPesquisa(@RequestBody @Valid pesquisa: Pesquisa): Pesquisa {
            return pesquisaService.salvaPesquisa(pesquisa)
        }
        @DeleteMapping("/{idPesquisa}")
        fun apagarPesquisa(@PathVariable idPesquisa: Long) {
            return pesquisaService.apagaPesquisa(idPesquisa)
        }


}