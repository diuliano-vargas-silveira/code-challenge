package br.com.noe.codechallenge.services

import br.com.noe.codechallenge.dtos.question.SimpleQuestionResponseDTO
import br.com.noe.codechallenge.dtos.question.SubmitQuestionRequest
import br.com.noe.codechallenge.enums.Languages
import br.com.noe.codechallenge.models.Question
import br.com.noe.codechallenge.models.TestCase
import br.com.noe.codechallenge.utils.FileManager
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files

@Service
class QuestionService(val fileManager: FileManager) {

    private val BREAK_LINE = "\n"

    val questions = listOf(
        Question(
            1,
            "Hello ...",
            "Write a function that receives a string and returns a greeting message with the string",
            1000,
            "hello",
            listOf(
                TestCase(1, "\"Brasil\"", "Hello Brasil!", false),
                TestCase(2, "\"World\"", "Hello World!", false)
            )
        ),
        Question(
            2,
            "Reverse a string",
            "Write a function that reverses a string",
            1000,
            "reverse",
            listOf(
                TestCase(3, "\"hello\"", "olleh", false),
                TestCase(4, "\"world\"", "dlrow", false)
            )
        )
    )

    fun getQuestionsP(): List<SimpleQuestionResponseDTO> {
        return questions.map { SimpleQuestionResponseDTO(it.id, it.title) }
    }

    fun submitQuestion(id: Int, submitQuestion: SubmitQuestionRequest): String {
        val selectedQuestion = questions.find { it.id == id }

        if (selectedQuestion == null)
            throw Exception("Question not found")

        fileManager.writeFile(submitQuestion, selectedQuestion)

        val output = compileFile(submitQuestion.language)
        val outputArray = output.split(BREAK_LINE).toMutableList()
        outputArray.pop()

        var correctAnswers = 0
        selectedQuestion.testCases.forEachIndexed() { index, textCase ->
            if (textCase.expectedOutput == outputArray[index]) {
                correctAnswers++
            }
        }

        return output
    }

    private fun compileFile(language: Languages): String {
        return ProcessBuilder(language.runCommand, fileManager.getFilePath(language))
            .start()
            .inputStream
            .bufferedReader().readText()
    }

    fun<E> MutableList<E>.pop(): E {
        val item = this.last()
        this.removeAt(this.size - 1)
        return item
    }


}