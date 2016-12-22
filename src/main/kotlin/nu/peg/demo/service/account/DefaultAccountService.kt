package nu.peg.demo.service.account

import nu.peg.demo.service.account.AccountService
import nu.peg.demo.data.account.Account
import nu.peg.demo.data.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultAccountService @Autowired constructor(val accountRepository: AccountRepository) : AccountService {
    override fun findAll(): List<Account> =
            accountRepository.findAll().toList()

    override fun createAccount(): Account =
            accountRepository.save(Account())

    override fun loadAccount(accountId: Long, amount: Double): Account? {
        val account = accountRepository.findOne(accountId) ?: return null
        account.credit(amount)
        return accountRepository.save(account)
    }
}