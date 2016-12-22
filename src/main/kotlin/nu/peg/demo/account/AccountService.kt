package nu.peg.demo.account

import nu.peg.demo.data.account.Account

interface AccountService {
    fun findAll(): List<Account>

    fun createAccount(): Account

    fun loadAccount(accountId: Long, amount: Double): Account?
}