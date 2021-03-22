package com.example.demo.payment.domain.service

import com.example.demo.payment.domain.Money
import org.springframework.stereotype.Component

interface GatewayProvider {
    fun pay(amount: Money)
}