package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName


internal data class ImageMetadataDTO(
    @SerializedName("id") var id: String? = null,
    @SerializedName("contentType") var contentType: String? = null,
    @SerializedName("effects") var effects: ArrayList<String> = arrayListOf(),
    @SerializedName("resources") var resources: String? = null
)