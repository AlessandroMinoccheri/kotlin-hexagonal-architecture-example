package com.example.demo.payment.legacy.controller

import com.example.demo.payment.legacy.service.PaymentService
import com.example.demo.payment.legacy.dto.Amount
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/legacy")
class BadController(val paymentService: PaymentService) {
    @PostMapping("/pay")
    fun payAction(@RequestBody amount: Amount): String {
        paymentService.pay(amount)
        return "Done."
    }
}