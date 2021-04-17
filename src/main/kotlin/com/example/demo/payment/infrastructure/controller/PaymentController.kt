package com.example.demo.payment.infrastructure.controller

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.application.service.CustomerService
import com.example.demo.payment.domain.Money
import com.example.demo.payment.domain.service.Payment
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class PaymentController(val customerService: CustomerService, val payment: Payment) {
    @GetMapping("/")
    fun test(): List<Message> {
        return listOf(
            Message("000-000", "foo"),
            Message("000-001", "bar"),
            Message("000-002", "baz"),
        )
    }

    @GetMapping("/customers")
    fun getResources(): List<Customer> = customerService.findAllCustomers()

    @PostMapping("/customers")
    fun createCustomer(@RequestBody customerRequest: CustomerRequest): CustomerResponse {
        val customer = customerService.save(customerRequest.firstname, customerRequest.lastname)
        return CustomerResponse(id = customer.id, firstname = customer.firstName, lastname = customer.lastName);
    }

    @PostMapping("/pay")
    fun payAction(@RequestBody amount: Money): String {
        payment.doPayment(amount)

        return "Done."
    }
}

data class Message(val id: String, val text: String)

class CustomerRequest (val firstname: String, val lastname: String)
class CustomerResponse (val id: String, val firstname: String, val lastname: String)
