package nu.peg.demo.controller

import nu.peg.demo.account.AccountService
import nu.peg.demo.data.account.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/account")
class AccountController @Autowired constructor(val accountService: AccountService) {

    @GetMapping("")
    fun findAllAccounts(): List<Account> =
            accountService.findAll()

    @GetMapping("/create")
    fun createAccount(): Account =
            accountService.createAccount()
}