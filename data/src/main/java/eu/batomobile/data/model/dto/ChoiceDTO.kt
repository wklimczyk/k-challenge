package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName


internal data class ChoiceDTO(
    @SerializedName("answer") var answer: String? = null,
    @SerializedName("correct") var correct: Boolean? = null,
    @SerializedName("languageInfo") var languageInfoDTO: LanguageInfoDTO? = LanguageInfoDTO()
)