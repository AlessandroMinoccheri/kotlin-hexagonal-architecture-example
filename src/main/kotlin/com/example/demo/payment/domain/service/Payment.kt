package com.example.demo.payment.domain.service

import com.example.demo.payment.domain.Money
import org.springframework.stereotype.Component

@Component
class Payment (private val gatewayProvider: GatewayProvider) {
    fun doPayment(amount: Money) {
        gatewayProvider.pay(amount)
    }
}
