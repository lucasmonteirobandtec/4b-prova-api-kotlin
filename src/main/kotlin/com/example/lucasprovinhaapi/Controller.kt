package com.example.lucasprovinhaapi

import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/boletins")
class Controller {

    var boletins = mutableListOf<Boletim>()

    @GetMapping
    fun boletins():List<Boletim>{
        return boletins
    }

    @GetMapping("/{id}")
    fun boletimAluno(@PathVariable id: Int): Boletim {
        return boletins[id - 1]
    }

    @DeleteMapping("/{id}")
    fun deleteBoletim(@PathVariable("id") id: Int): String{
        return try{
            val boletim:Boletim = boletins[id - 1]
            boletins.remove(boletim)
            "Boletim excluído com sucesso"
        } catch (e:Exception) {
            "Boletim não encontrado!"
        }
    }

    @PostMapping
    fun createBoletim(@RequestBody boletim:Boletim): String{
        boletins.add(boletim)
        return "Boletim Criado"
    }


    @GetMapping("so-os-tops")
    fun boletimSoOsTops():List<Boletim>{
        val soostops = boletins.filter { it.media >= 9.5 }
        return soostops
    }

}