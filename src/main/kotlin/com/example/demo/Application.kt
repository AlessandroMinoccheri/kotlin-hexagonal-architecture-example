package com.example.demo

import com.example.demo.payment.application.service.CustomerService
import com.example.demo.payment.infrastructure.handler.CustomerHandler
import com.example.demo.payment.infrastructure.repository.CustomerRepository
import com.example.demo.payment.infrastructure.routes.CustomerRoutes
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.RouterFunctions

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args){
        addInitializers(allBeans())
    }
}

fun allBeans(): BeanDefinitionDsl {
    return beans {
        this.bean<CustomerRepository>()
        this.bean<CustomerService>()
        this.bean<CustomerHandler>()
        this.bean(CustomerRoutes::routes)

    }
}
