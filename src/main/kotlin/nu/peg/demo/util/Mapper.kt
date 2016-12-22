package nu.peg.demo.util

interface Mapper<Entity, Dto> {
    fun toDto(entity: Entity): Dto
    fun fromDto(dto: Dto): Entity
}