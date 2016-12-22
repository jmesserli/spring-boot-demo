package nu.peg.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringBootDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootDemoApplication::class.java, *args)
}
