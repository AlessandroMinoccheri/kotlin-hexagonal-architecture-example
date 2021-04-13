package com.example.demo.payment.domain.service

import com.example.demo.payment.domain.Money

interface GatewayProvider {
    fun pay(amount: Money)
}