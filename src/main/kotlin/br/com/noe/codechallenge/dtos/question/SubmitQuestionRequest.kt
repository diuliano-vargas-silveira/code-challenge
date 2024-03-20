package br.com.noe.codechallenge.dtos.question

import br.com.noe.codechallenge.enums.Languages
import io.swagger.v3.oas.annotations.media.Schema

data class SubmitQuestionRequest(
    @Schema(name = "code", example = "function hello() { return 'Hello' }")
    val code: String,
    @Schema(name = "language", example = "JAVASCRIPT")
    val language: Languages
)
