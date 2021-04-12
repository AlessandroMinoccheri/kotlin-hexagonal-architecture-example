package com.example.demo.payment.legacy.model

import com.example.demo.payment.legacy.dto.Amount
import com.example.demo.payment.legacy.service.PaymentService

class User {
    fun pay(paymentService: PaymentService, amount: Amount) {
        paymentService.pay(amount)
    }
}