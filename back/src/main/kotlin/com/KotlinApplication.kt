package com

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.repository"])
@EnableJpaRepositories("com")
class KotlinApplication

fun main(args: Array<String>) {
    runApplication<KotlinApplication>(*args)
}
