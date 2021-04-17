package com.example.demo.payment.infrastructure.handler

import com.example.demo.payment.application.service.CustomerService
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

class CustomerRequest (val firstname: String, val lastname: String)
class CustomerResponse (val id: String, val firstname: String, val lastname: String)

class CustomerHandler(private val customerService: CustomerService) {
    fun create(request: ServerRequest): ServerResponse {
        val customerRequest = request.body(CustomerRequest::class.java)
        val customer = customerService.save(customerRequest.firstname, customerRequest.lastname)
        return ServerResponse.ok().body(CustomerResponse(id = customer.id, firstname = customer.firstName, lastname = customer.lastName))
    }

    fun list(): ServerResponse {
        val customers = customerService
            .findAllCustomers()
            .map { customer ->
                CustomerResponse(
                    id = customer.id,
                    firstname = customer.firstName,
                    lastname = customer.lastName
                )
            }

        return ServerResponse.ok().body(customers)
    }
}