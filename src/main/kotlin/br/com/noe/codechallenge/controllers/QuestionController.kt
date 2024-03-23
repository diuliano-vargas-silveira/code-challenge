package br.com.noe.codechallenge.controllers

import br.com.noe.codechallenge.controllers.documentations.QuestionControllerDoc
import br.com.noe.codechallenge.dtos.question.SimpleQuestionResponseDTO
import br.com.noe.codechallenge.dtos.question.SubmitQuestionRequest
import br.com.noe.codechallenge.services.QuestionService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/questions")
data class QuestionController(val questionService: QuestionService) : QuestionControllerDoc {

    @GetMapping
    override fun getQuestions(): List<SimpleQuestionResponseDTO> = questionService.getQuestionsP()

    @PostMapping("/{id}")
    override fun submitQuestion(@PathVariable id: Int, @RequestBody submitQuestion: SubmitQuestionRequest): String {
    suspend fun submitQuestion(@PathVariable id: Int, @RequestBody submitQuestion: SubmitQuestionRequest): String {
        return questionService.submitQuestion(id, submitQuestion)
    }
}
