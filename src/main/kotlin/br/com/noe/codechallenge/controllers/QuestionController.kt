package br.com.noe.codechallenge.controllers

import br.com.noe.codechallenge.dtos.question.SimpleQuestionResponseDTO
import br.com.noe.codechallenge.dtos.question.SubmitQuestionRequest
import br.com.noe.codechallenge.services.QuestionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/questions")
data class QuestionController(val questionService: QuestionService) {

    @GetMapping
    fun getQuestions(): List<SimpleQuestionResponseDTO> = questionService.getQuestionsP()

    @PostMapping("/{id}")
    suspend fun submitQuestion(@PathVariable id: Int, @RequestBody submitQuestion: SubmitQuestionRequest): String {
        return questionService.submitQuestion(id, submitQuestion)
    }
}
