package eu.batomobile.data.mapper

import eu.batomobile.data.mapper.base.Mapper
import eu.batomobile.data.model.dto.ChoiceDTO
import eu.batomobile.data.model.dto.QuestionDTO
import eu.batomobile.domain.entity.Choice
import eu.batomobile.domain.entity.Question

internal class QuestionMapper : Mapper<Question, QuestionDTO> {
    override fun mapToEntity(dto: QuestionDTO): Question = Question(
        question = dto.question,
        choices = dto.choices.map { ChoiceMapper().mapToEntity(it) } as ArrayList<Choice>
    )

    override fun mapToDTO(entity: Question): QuestionDTO = QuestionDTO(
        question = entity.question,
        choices = entity.choices.map { ChoiceMapper().mapToDTO(it) } as ArrayList<ChoiceDTO>
    )
}