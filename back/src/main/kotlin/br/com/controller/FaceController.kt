package br.com.controller

import br.com.dto.Face
import br.com.service.FaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/faces")
class FaceController(

    @Autowired
    private val faceService: FaceService
) {
    //TODO: validacção de contrato não está funcionando

    @GetMapping("/")
    fun listaFaces(): ResponseEntity<List<Face>> {
        return ResponseEntity.ok<List<Face>>(faceService.listaFaces())
    }

    @GetMapping("/{idFace}")
    fun listaFace(@PathVariable idFace: Long): ResponseEntity<Face> {
        return ResponseEntity.ok<Face>(faceService.listaFace(idFace))
    }

    @PostMapping("/face")
    fun criaFace(@RequestBody @Valid face: Face): Face {
        println(face.toString())
        return faceService.criaFace(face)
    }

    @DeleteMapping("/{idFace}")
    fun apagaFace(@PathVariable idFace: Long){
        return faceService.apagaFace(idFace)
    }
}