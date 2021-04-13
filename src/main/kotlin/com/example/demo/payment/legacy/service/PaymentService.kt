package com.example.demo.payment.legacy.service

import com.example.demo.payment.legacy.dto.Amount
import com.example.demo.payment.legacy.model.User
import org.springframework.stereotype.Service

@Service
class PaymentService {
    fun pay(amount: Amount){
        println("Payment done.")
    }

    fun getByUser(user: User){
        println("List of payments.")
    }
}