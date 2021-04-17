package com.example.demo

import com.example.demo.payment.application.service.CustomerService
import com.example.demo.payment.domain.repository.CustomerRepository
import com.example.demo.payment.infrastructure.handler.CustomerHandler
import com.example.demo.payment.infrastructure.repository.CustomerRepositoryH2
import com.example.demo.payment.infrastructure.routes.CustomerRoutes
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args){
        addInitializers(allBeans())
    }
}

fun allBeans(): BeanDefinitionDsl {
    return beans {
        this.bean<CustomerRepositoryH2>(name = CustomerRepository::class.java.name)
        this.bean<CustomerService>()
        this.bean<CustomerHandler>()
        this.bean(CustomerRoutes::routes)

    }
}
