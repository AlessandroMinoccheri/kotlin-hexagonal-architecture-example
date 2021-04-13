package com.example.demo.payment.legacy.service

import com.example.demo.payment.legacy.model.User
import org.springframework.stereotype.Service

@Service
class UserService {
    fun getPayments(paymentService: PaymentService, user: User) {
        paymentService.getByUser(user)
    }
}