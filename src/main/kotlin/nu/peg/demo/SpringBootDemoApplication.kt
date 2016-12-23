package nu.peg.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication
open class SpringBootDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootDemoApplication::class.java, *args)
}