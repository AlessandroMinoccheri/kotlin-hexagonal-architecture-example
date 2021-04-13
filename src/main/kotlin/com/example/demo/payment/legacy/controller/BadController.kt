package com.example.demo.payment.legacy.controller

import com.example.demo.payment.legacy.service.PaymentService
import com.example.demo.payment.legacy.dto.Amount
import com.example.demo.payment.legacy.model.User
import com.example.demo.payment.legacy.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/legacy")
class BadController(val paymentService: PaymentService, val userService: UserService) {
    @PostMapping("/pay")
    fun payAction(@RequestBody amount: Amount): String {
        paymentService.pay(amount)
        return "Done."
    }

    @PostMapping("/user/pay")
    fun payUserAction(@RequestBody user: User, amount: Amount): String {
        user.pay(paymentService, amount)
        return "Done."
    }

    @GetMapping("/user/payments")
    fun userPaymentsAction(@RequestBody user: User, amount: Amount): String {
        userService.getPayments(paymentService, user)
        return "Done."
    }
}





