package com.example.lucasprovinhaapi

class Boletim {

    var aluno:String
    var nota1:Double
    var nota2:Double
    var media:Double = 0.0

    constructor(aluno: String, nota1: Double, nota2: Double) {
        this.aluno = aluno
        this.nota1 = nota1
        this.nota2 = nota2
        this.media = (nota1+nota2)/2
    }
}