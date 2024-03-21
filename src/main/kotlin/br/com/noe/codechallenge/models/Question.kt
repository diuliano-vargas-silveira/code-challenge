package br.com.noe.codechallenge.models

import jakarta.persistence.*
import org.springframework.context.annotation.Description

@Entity
class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val title: String,
    val description: String,
    val timeLimit: Long,
    val className: String,
    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val testCases: List<TestCase>
)