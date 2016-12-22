package nu.peg.demo.service.transfer.internal

import com.google.common.truth.Truth.assertThat
import nu.peg.demo.service.account.AccountService
import nu.peg.demo.data.account.Account
import nu.peg.demo.data.account.AccountRepository
import nu.peg.demo.data.transfer.TransferDtoMapper
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional

@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
@Ignore
class DefaultTransferServiceTest {
    @Autowired lateinit var accountService: AccountService
    @Autowired lateinit var accountRepository: AccountRepository
    @Autowired lateinit var transferService: DefaultTransferService
    @Autowired lateinit var transferDtoMapper: TransferDtoMapper

    lateinit var accounts: MutableList<Account>

    @Before
    fun setUp() {
        accounts = mutableListOf()
        var account1: Account = accountService.createAccount()
        account1 = accountService.loadAccount(account1.id!!, 1000.0)!!
        accounts.add(account1)
        accounts.add(accountService.createAccount())
    }

    @After
    fun tearDown() {

    }

    @Test
    fun transferWithId() {
        val transfer = transferService.transfer(accounts[0].id!!, accounts[1].id!!, 200.0)
        assertThat(transfer).isNotNull()
        assertThat(accountRepository.findOne(accounts[0].id).balance).isEqualTo(800.0)
        assertThat(accountRepository.findOne(accounts[1].id).balance).isEqualTo(200.0)
    }

    @Test
    fun transferWithInstance() {
        val transfer = transferService.transfer(accounts[0], accounts[1], 200.0)
        assertThat(transfer).isNotNull()
        assertThat(accountRepository.findOne(accounts[0].id).balance).isEqualTo(800.0)
        assertThat(accountRepository.findOne(accounts[1].id).balance).isEqualTo(200.0)
    }

    @Test
    fun findAll() {
        val findAll = transferService.findAll()
        assertThat(findAll).isEmpty()
    }

}