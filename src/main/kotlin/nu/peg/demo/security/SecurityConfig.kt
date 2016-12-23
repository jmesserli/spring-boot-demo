package nu.peg.demo.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()?.withUser("joel")?.password("helloworld")?.roles("ADMIN")
    }
}