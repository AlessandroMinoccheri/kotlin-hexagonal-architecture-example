package com.example.demo.payment.infrastructure.service

import com.example.demo.payment.domain.Money
import com.example.demo.payment.domain.service.GatewayProvider
import org.springframework.stereotype.Component

@Component
class YourBankGateway constructor(): GatewayProvider {
    override fun pay(amount: Money) {
        println("You have paid $amount")
    }
}
