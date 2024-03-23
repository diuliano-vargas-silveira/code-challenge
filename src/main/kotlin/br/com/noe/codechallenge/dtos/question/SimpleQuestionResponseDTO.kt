package br.com.noe.codechallenge.dtos.question

import io.swagger.v3.oas.annotations.media.Schema

data class SimpleQuestionResponseDTO(
    @Schema(description = "ID", example = "1")
    val id: Int,
    @Schema(description = "Title", example = "Hello Something")
    val title: String
)

