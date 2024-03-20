package br.com.noe.codechallenge.models

import jakarta.persistence.*

@Entity
class TestCase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val input: String,
    val expectedOutput: String,
    val isOcult: Boolean,
    @ManyToOne(fetch = FetchType.LAZY)
    val question: Question? = null
)