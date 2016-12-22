package nu.peg.demo.data.transfer

import nu.peg.demo.data.transfer.Transfer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TransferRepository : CrudRepository<Transfer, UUID> {
}