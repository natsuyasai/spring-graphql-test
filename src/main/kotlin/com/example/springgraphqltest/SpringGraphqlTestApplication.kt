package com.example.springgraphqltest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.example.springgraphqltest.repository")
class SpringGraphqlTestApplication

fun main(args: Array<String>) {
	runApplication<SpringGraphqlTestApplication>(*args)
}
