package nu.peg.demo.transfer.internal

import nu.peg.demo.data.account.Account
import nu.peg.demo.data.account.AccountRepository
import nu.peg.demo.data.transfer.Transfer
import nu.peg.demo.data.transfer.TransferRepository
import nu.peg.demo.transfer.TransferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DefaultTransferService @Autowired constructor(val transferRepository: TransferRepository,
                                                    val accountRepository: AccountRepository) : TransferService {
    override fun transfer(sourceId: Long, targetId: Long, amount: Double): UUID? {
        val source = accountRepository.findOne(sourceId)
        val target = accountRepository.findOne(targetId)

        return transfer(source, target, amount)
    }

    override fun transfer(source: Account, target: Account, amount: Double): UUID? {
        val debitSuccessful = source.debit(amount)
        if (!debitSuccessful) {
            throw Exception("Could not debit the source account successfully")
        }

        val creditSuccessful = target.credit(amount)
        if (!creditSuccessful) {
            throw Exception("Could not credit the target account successfully")
        }

        accountRepository.save(listOf(source, target))

        val transfer = Transfer()
        transfer.source = source
        transfer.target = target
        transfer.amount = amount
        transfer.newTargetBalance = target.balance

        return transferRepository.save(transfer).confirmationId
    }

    override fun findAll(): List<Transfer> {
        return transferRepository.findAll().toList();
    }
}