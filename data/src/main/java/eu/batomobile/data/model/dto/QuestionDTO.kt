package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName

internal data class QuestionDTO(
    @SerializedName("type") var type: String? = null,
    @SerializedName("question") var question: String? = null,
    @SerializedName("time") var time: Int? = null,
    @SerializedName("points") var points: Boolean? = null,
    @SerializedName("pointsMultiplier") var pointsMultiplier: Int? = null,
    @SerializedName("choices") var choices: ArrayList<ChoiceDTO> = arrayListOf(),
    @SerializedName("layout") var layout: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("imageMetadata") var imageMetadata: ImageMetadataDTO? = ImageMetadataDTO(),
    @SerializedName("resources") var resources: String? = null,
    @SerializedName("video") var video: VideoDTO? = VideoDTO(),
    @SerializedName("questionFormat") var questionFormat: Int? = null,
    @SerializedName("languageInfo") var languageInfo: LanguageInfoDTO? = LanguageInfoDTO(),
    @SerializedName("media") var media: ArrayList<String> = arrayListOf()
)