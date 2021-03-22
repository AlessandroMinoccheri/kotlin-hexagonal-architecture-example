package com.example.demo.payment.legacy.controller

import com.example.demo.payment.legacy.service.Payment
import com.example.demo.payment.application.service.CustomerService
import com.example.demo.payment.legacy.dto.Amount
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/legacy")
class BadController(val service: CustomerService) {
    @PostMapping("/pay")
    fun payAction(@RequestBody amount: Amount): String {
        val payment = Payment()
        payment.pay(amount)
        return "Done."
    }
}