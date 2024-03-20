package br.com.noe.codechallenge.services

import br.com.noe.codechallenge.dtos.question.SimpleQuestionResponseDTO
import br.com.noe.codechallenge.dtos.question.SubmitQuestionRequest
import br.com.noe.codechallenge.models.Question
import br.com.noe.codechallenge.models.TestCase
import br.com.noe.codechallenge.utils.FileManager
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files

@Service
class QuestionService(val fileManager: FileManager) {

    val questions = listOf(
        Question(
            1,
            "Hello ...",
            "Write a function that receives a string and returns a greeting message with the string",
            1000,
            "hello",
            listOf(
                TestCase(1, "Brasil", "Hello Brasil!", false),
                TestCase(2, "World", "Hello World!", false)
            )
        ),
        Question(
            2,
            "Reverse a string",
            "Write a function that reverses a string",
            1000,
            "reverse",
            listOf(
                TestCase(3, "hello", "olleh", false),
                TestCase(4, "world", "dlrow", false)
            )
        )
    )

    fun getQuestionsP(): List<SimpleQuestionResponseDTO> {
        return questions.map { SimpleQuestionResponseDTO(it.id, it.title) }
    }

    fun submitQuestion(id: Int, submitQuestion: SubmitQuestionRequest) {
       val selectedQuestion = questions.find { it.id == id }

        if (selectedQuestion == null)
            throw Exception("Question not found")

        fileManager.writeFile(submitQuestion, selectedQuestion)
    }


}