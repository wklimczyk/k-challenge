package eu.batomobile.data.model.dto

import com.google.gson.annotations.SerializedName


internal data class MetadataDTO(
    @SerializedName("access") var access: AccessDTO? = AccessDTO(),
    @SerializedName("duplicationProtection") var duplicationProtection: Boolean? = null,
//    @SerializedName("lastEdit") var lastEdit: LastEditEntity? = LastEditEntity(),
//    @SerializedName("versionMetadata") var versionMetadata: VersionMetadataEntity? = VersionMetadataEntity()
)