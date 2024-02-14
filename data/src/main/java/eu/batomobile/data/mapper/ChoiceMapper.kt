package eu.batomobile.data.mapper

import eu.batomobile.data.mapper.base.Mapper
import eu.batomobile.data.model.dto.ChoiceDTO
import eu.batomobile.domain.entity.Choice

internal class ChoiceMapper : Mapper<Choice, ChoiceDTO> {
    override fun mapToEntity(dto: ChoiceDTO): Choice = Choice(
        answer = dto.answer!!,
        correct = dto.correct!!
    )

    override fun mapToDTO(entity: Choice): ChoiceDTO = ChoiceDTO(
        answer = entity.answer,
        correct = entity.correct
    )
}