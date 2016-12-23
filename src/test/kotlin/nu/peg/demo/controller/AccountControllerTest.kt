package nu.peg.demo.controller

import com.google.common.truth.Truth.assertThat
import nu.peg.demo.data.account.Account
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class AccountControllerTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun findAllAccounts() {
        val accountsEntity = restTemplate.withBasicAuth("joel", "joel").getForEntity("/api/account", Array<Account>::class.java)
        assertThat(accountsEntity.statusCode).isEqualTo(HttpStatus.OK)

        val accounts = accountsEntity.body
        assertThat(accounts).isEmpty()
    }
}