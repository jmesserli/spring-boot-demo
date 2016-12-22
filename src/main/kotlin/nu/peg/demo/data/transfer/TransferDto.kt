package nu.peg.demo.data.transfer

import java.util.*

data class TransferDto(val confirmationId: UUID, val sourceId: Long, val targetId: Long, val amount: Double, val newTargetBalance: Double)