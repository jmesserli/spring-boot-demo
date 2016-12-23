package nu.peg.demo.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
open class SecurityConfig @Autowired constructor(val secProps: SecurityProperties) : WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()?.withUser(secProps.user.name)?.password(secProps.user.password)?.roles("ADMIN")
    }

    override fun configure(http: HttpSecurity?) {
        super.configure(http)

        http!!.csrf().disable()
                .headers().frameOptions().disable()
    }
}