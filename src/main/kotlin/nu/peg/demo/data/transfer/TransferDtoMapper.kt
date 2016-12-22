package nu.peg.demo.data.transfer

import nu.peg.demo.util.Mapper
import org.springframework.stereotype.Component

@Component
open class TransferDtoMapper : Mapper<Transfer, TransferDto> {
    override fun toDto(entity: Transfer): TransferDto {
        return TransferDto(
                entity.confirmationId!!,
                entity.source?.id,
                entity.target?.id,
                entity.amount,
                entity.newTargetBalance)
    }

    override fun fromDto(dto: TransferDto): Transfer {
        throw UnsupportedOperationException("not implemented")
    }

}
