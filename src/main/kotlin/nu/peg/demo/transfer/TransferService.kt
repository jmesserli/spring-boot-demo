package nu.peg.demo.transfer

import nu.peg.demo.data.account.Account
import nu.peg.demo.data.transfer.Transfer
import java.util.*

interface TransferService {

    /**
     * This is the same as transfer with accounts, it just fetches the accounts with the given ids first
     */
    fun transfer(sourceId: Long, targetId: Long, amount: Double): UUID?

    /**
     * Transfers money from the source to the target account
     * @param source The account to transfer money from
     * @param target The account to transfer money to
     * @param amount How much money should be transferred
     * @return A confirmation id
     */
    fun transfer(source: Account, target: Account, amount: Double): UUID?

    /**
     * Retrieve a list of processed transfers
     */
    fun findAll(): List<Transfer>
}