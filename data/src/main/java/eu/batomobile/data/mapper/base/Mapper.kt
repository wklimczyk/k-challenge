package eu.batomobile.data.mapper.base

// Mapper could either throw some exception on null values which would be caught
// in the use case or return some default value//error
// or return nullable and results could be filtered depending on the use case
internal interface Mapper<E, D> {

    fun mapToEntity(dto: D): E
    fun mapToDTO(entity: E): D
}