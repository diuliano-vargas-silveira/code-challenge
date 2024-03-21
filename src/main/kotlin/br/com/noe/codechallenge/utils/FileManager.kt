package br.com.noe.codechallenge.utils

import br.com.noe.codechallenge.dtos.question.SubmitQuestionRequest
import br.com.noe.codechallenge.enums.Languages
import br.com.noe.codechallenge.models.Question
import br.com.noe.codechallenge.models.TestCase
import org.springframework.stereotype.Component
import java.io.File

@Component
class FileManager {

    private val DEFAULT_PATH = "src/main/resources/files/file"

    fun writeFile(submitQuestionRequest: SubmitQuestionRequest, question: Question) {
        val language = submitQuestionRequest.language
        val code = submitQuestionRequest.code

        createDefaultDirectoryIfNotExists()

        val file = File(getFilePath(language))
        file.writeText(code + "\n")

        val className = question.className
        val testCases = question.testCases

        when (language) {
            Languages.JAVASCRIPT ->
                writeTestCasesJS(file, className, testCases)

            Languages.C ->
                writeTestCasesC(file, className, testCases)

            Languages.JAVA ->
                writeTestCasesJava(file, className, testCases)

            Languages.PYTHON3 ->
                writeTestCasesPython(file, className, testCases)

        }
    }

    fun getFilePath(language: Languages): String {
        return DEFAULT_PATH + language.extension
    }

    private fun createDefaultDirectoryIfNotExists() {
        var directory = File(DEFAULT_PATH.removeSuffix("/file"))

        if(!directory.exists()) {
            val isDirectoryCreatedSuccessfully = directory.mkdirs()

            if(!isDirectoryCreatedSuccessfully) {
                throw RuntimeException("Failed to create default directory.")
            }
        }
    }

    private fun writeTestCasesJS(file: File, className: String, testCases: List<TestCase>) {
        testCases.forEach {
            file.appendText("console.log($className(${it.input}))\n")
        }
    }

    private fun writeTestCasesC(file: File, className: String, testCases: List<TestCase>) {
        TODO("Not yet implemented")
    }

    private fun writeTestCasesJava(file: File, className: String, testCases: List<TestCase>) {
        TODO("Not yet implemented")
    }

    private fun writeTestCasesPython(file: File, className: String, testCases: List<TestCase>) {
        TODO("Not yet implemented")
    }

}
