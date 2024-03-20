package br.com.noe.codechallenge.dtos.question

import br.com.noe.codechallenge.enums.Languages


data class SubmitQuestionRequest(val code: String, val language: Languages)
