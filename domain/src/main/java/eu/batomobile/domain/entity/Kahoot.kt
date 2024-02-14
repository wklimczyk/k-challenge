package eu.batomobile.domain.entity

data class Kahoot(
    var uuid: String? = null,
    var title: String? = null,
    var description: String? = null,
    var quizType: String? = null,
    var cover: String? = null,
    var questions: ArrayList<Question>,
)