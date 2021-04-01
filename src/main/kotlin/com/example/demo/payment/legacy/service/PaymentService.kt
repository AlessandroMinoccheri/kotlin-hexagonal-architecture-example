package com.example.demo.payment.legacy.service

import com.example.demo.payment.legacy.dto.Amount
import org.springframework.stereotype.Service

@Service
class PaymentService(val bankGateway: YourBankGatewayService) {
    fun pay(amount: Amount){
        bankGateway.pay(amount.value)
    }
}