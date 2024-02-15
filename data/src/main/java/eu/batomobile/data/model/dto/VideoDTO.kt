package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName


internal data class VideoDTO(
    @SerializedName("id") var id: String? = null,
    @SerializedName("startTime") var startTime: Long? = null,
    @SerializedName("endTime") var endTime: Long? = null,
    @SerializedName("service") var service: String? = null,
    @SerializedName("fullUrl") var fullUrl: String? = null
)