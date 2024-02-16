package eu.batomobile.domain.entity


data class Question(
    var type: String? = null,
    var question: String? = null,
    var time: Long? = null,
    var points: Boolean? = null,
    var pointsMultiplier: Int? = null,
    var choices: ArrayList<Choice> = arrayListOf(),
    var layout: String? = null,
    var image: String? = null,
    var media: ArrayList<String> = arrayListOf()
)