package eu.batomobile.data.model.response

import com.google.gson.annotations.SerializedName
import eu.batomobile.data.model.dto.CoverMetadataDTO
import eu.batomobile.data.model.dto.LanguageInfoDTO
import eu.batomobile.data.model.dto.MetadataDTO
import eu.batomobile.data.model.dto.QuestionDTO


internal data class KahootResponse(
    @SerializedName("uuid") var uuid: String? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("creator") var creator: String? = null,
    @SerializedName("creator_username") var creatorUsername: String? = null,
    @SerializedName("compatibilityLevel") var compatibilityLevel: Int? = null,
    @SerializedName("creator_primary_usage") var creatorPrimaryUsage: String? = null,
    @SerializedName("folderId") var folderId: String? = null,
    @SerializedName("themeId") var themeId: String? = null,
    @SerializedName("visibility") var visibility: Int? = null,
    @SerializedName("audience") var audience: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("quizType") var quizType: String? = null,
    @SerializedName("cover") var cover: String? = null,
    @SerializedName("coverMetadata") var coverMetadata: CoverMetadataDTO? = CoverMetadataDTO(),
    @SerializedName("questions") var questions: ArrayList<QuestionDTO> = arrayListOf(),
    @SerializedName("metadata") var metadataEntity: MetadataDTO? = MetadataDTO(),
    @SerializedName("resources") var resources: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("languageInfo") var languageInfoDTO: LanguageInfoDTO? = LanguageInfoDTO(),
    @SerializedName("inventoryItemIds") var inventoryItemIds: ArrayList<String> = arrayListOf(),
    @SerializedName("isValid") var isValid: Boolean? = null,
    @SerializedName("playAsGuest") var playAsGuest: Boolean? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("created") var created: Long? = null,
    @SerializedName("modified") var modified: Long? = null
)