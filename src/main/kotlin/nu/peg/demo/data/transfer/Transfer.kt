package nu.peg.demo.data.transfer

import nu.peg.demo.data.account.Account
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var confirmationId: UUID? = null

    @ManyToOne
    var source: Account? = null

    @ManyToOne
    var target: Account? = null

    @NotNull
    var amount: Double = 0.0

    @NotNull
    var newTargetBalance: Double = 0.0
}