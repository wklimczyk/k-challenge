package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName

internal data class AccessDTO(
    @SerializedName("groupRead") var groupRead: ArrayList<String> = arrayListOf(),
    @SerializedName("folderGroupIds") var folderGroupIds: ArrayList<String> = arrayListOf(),
    @SerializedName("features") var features: ArrayList<String> = arrayListOf()
)