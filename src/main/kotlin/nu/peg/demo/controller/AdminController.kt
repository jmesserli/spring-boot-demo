package nu.peg.demo.controller

import nu.peg.demo.service.account.AccountService
import nu.peg.demo.data.account.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
class AdminController @Autowired constructor(val accountService: AccountService) {

    @GetMapping("/account/{id}/load/{amount}")
    fun loadAccount(@PathVariable id: Long, @PathVariable amount: Double): Account? {
        return accountService.loadAccount(id, amount)
    }
}