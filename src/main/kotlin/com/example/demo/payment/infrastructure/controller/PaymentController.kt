package com.example.demo.payment.infrastructure.controller

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.application.service.CustomerService
import com.example.demo.payment.domain.Money
import com.example.demo.payment.domain.service.Payment
import com.example.demo.payment.legacy.dto.Amount
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class PaymentController(val service: CustomerService, val payment: Payment) {
    @GetMapping("/")
    fun test(): List<Message> {
        return listOf(
            Message("000-000", "foo"),
            Message("000-001", "bar"),
            Message("000-002", "baz"),
        )
    }

    @GetMapping("/customers")
    fun getResources(): List<Customer> = service.findCustomers()

    @PostMapping("/customers")
    fun createResource(@RequestBody customer: Customer): String {
        service.save(customer)
        return "Done."
    }

    @PostMapping("/pay")
    fun payAction(@RequestBody amount: Money): String {
        payment.doPayment(amount)
        return "Done."
    }
}

data class Message(val id: String, val text: String)
