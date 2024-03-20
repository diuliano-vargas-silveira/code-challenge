package br.com.noe.codechallenge.controllers.documentations

import br.com.noe.codechallenge.dtos.question.SimpleQuestionResponseDTO
import br.com.noe.codechallenge.dtos.question.SubmitQuestionRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Questions")
interface QuestionControllerDoc {

    @Operation(summary = "Get all questions",
        responses = [
            ApiResponse(responseCode = "200", description = "Return a list of questions"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ])
    fun getQuestions(): List<SimpleQuestionResponseDTO>

    @Operation(summary = "Submit a question",
        responses = [
            ApiResponse(responseCode = "200", description = "Return a message"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ])
    fun submitQuestion(@PathVariable id: Int, @RequestBody submitQuestion: SubmitQuestionRequest): String


}