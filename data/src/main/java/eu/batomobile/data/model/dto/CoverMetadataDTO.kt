package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName


internal data class CoverMetadataDTO(
    @SerializedName("id") var id: String? = null,
    @SerializedName("contentType") var contentType: String? = null,
    @SerializedName("resources") var resources: String? = null
)