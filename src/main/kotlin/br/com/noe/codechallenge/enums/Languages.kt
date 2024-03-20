package br.com.noe.codechallenge.enums

enum class Languages(val languageName: String, val extension: String, val runCommand: String) {
    JAVASCRIPT("Javascript", ".js", "node"),
    C("C", ".c", "gcc"),
    JAVA("Java", ".java", "java"),
    PYTHON3("Python3", ".py", "python3")
}
