package nu.peg.demo.info

import nu.peg.demo.service.account.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.info.Info
import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.stereotype.Component

@Component
class AccountInfoContributor @Autowired constructor(val accountService: AccountService) : InfoContributor {
    override fun contribute(builder: Info.Builder?) {
        val allAccounts = accountService.findAll()
        builder?.withDetail("wealth", allAccounts.map { it.balance }.sum())
        builder?.withDetail("accounts", allAccounts.count())
    }
}