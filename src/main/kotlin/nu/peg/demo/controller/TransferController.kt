package nu.peg.demo.controller

import nu.peg.demo.data.transfer.Transfer
import nu.peg.demo.transfer.TransferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/transfer")
class TransferController @Autowired constructor(val transferService: TransferService) {

    @GetMapping("/{fromId}/{toId}/{amount}")
    fun transferMoney(@PathVariable fromId: Long, @PathVariable toId: Long, @PathVariable amount: Double): UUID? =
            transferService.transfer(fromId, toId, amount)

    @GetMapping("")
    fun findAllTransfers(): List<Transfer> =
            transferService.findAll()

}