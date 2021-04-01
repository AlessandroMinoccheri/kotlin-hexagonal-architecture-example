package com.example.demo.payment.legacy.service

import org.springframework.stereotype.Service

@Service
class YourBankGatewayService {
    fun pay(amount: Int){
        println("Payment Done of: " + amount)
    }
}