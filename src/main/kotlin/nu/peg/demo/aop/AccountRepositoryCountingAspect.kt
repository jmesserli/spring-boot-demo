package nu.peg.demo.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.stereotype.Component

@Component
@Aspect
open class AccountRepositoryCountingAspect @Autowired constructor(val counterService: CounterService) {
    @AfterReturning("execution(* nu.peg.demo.data.account.AccountRepository+.*(..))")
    fun afterSuccessfulCall(joinPoint: JoinPoint) {
        counterService.increment(joinPoint.signature.name)
    }
}