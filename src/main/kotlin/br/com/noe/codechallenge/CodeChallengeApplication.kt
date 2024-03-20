package br.com.noe.codechallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodeChallengeApplication

fun main(args: Array<String>) {
    runApplication<CodeChallengeApplication>(*args)
}
