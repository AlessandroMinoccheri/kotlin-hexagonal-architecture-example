package com.example.demo.payment.legacy.service

import com.example.demo.payment.legacy.dto.Amount

class Payment {
    fun pay(amount: Amount){
        val bankGateway = YourBankGateway()
        bankGateway.pay(amount.value)
    }
}