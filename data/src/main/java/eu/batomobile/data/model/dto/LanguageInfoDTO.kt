package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName


internal data class LanguageInfoDTO(
    @SerializedName("language") var language: String? = null,
    @SerializedName("lastUpdatedOn") var lastUpdatedOn: Int? = null,
    @SerializedName("readAloudSupported") var readAloudSupported: Boolean? = null
)