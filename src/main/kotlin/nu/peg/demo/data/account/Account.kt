package nu.peg.demo.data.account

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @NotNull
    var balance: Double = 0.0

    fun debit(amount: Double): Boolean {
        if (balance < amount) return false
        else balance -= amount
        return true
    }

    fun credit(amount: Double): Boolean {
        if (Double.MAX_VALUE - amount < balance) throw Exception("Adding more money would overflow the account")
        balance += amount

        return true
    }
}