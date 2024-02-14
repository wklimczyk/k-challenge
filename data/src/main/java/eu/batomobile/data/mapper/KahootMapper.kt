package eu.batomobile.data.mapper

import eu.batomobile.data.mapper.base.Mapper
import eu.batomobile.data.model.dto.QuestionDTO
import eu.batomobile.data.model.response.KahootResponse
import eu.batomobile.domain.entity.Kahoot
import eu.batomobile.domain.entity.Question
import javax.inject.Inject

internal class KahootMapper @Inject constructor() : Mapper<Kahoot, KahootResponse> {
    override fun mapToEntity(dto: KahootResponse): Kahoot = Kahoot(
        uuid = dto.uuid,
        title = dto.title,
        description = dto.description,
        quizType = dto.quizType,
        cover = dto.cover,
        questions = dto.questions.map { QuestionMapper().mapToEntity(it) } as ArrayList<Question>
    )

    override fun mapToDTO(entity: Kahoot): KahootResponse = KahootResponse(
        uuid = entity.uuid,
        title = entity.title,
        description = entity.description,
        quizType = entity.quizType,
        cover = entity.cover,
        questions = entity.questions.map { QuestionMapper().mapToDTO(it) } as ArrayList<QuestionDTO>
    )
}