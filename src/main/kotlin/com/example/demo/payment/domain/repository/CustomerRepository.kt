package com.example.demo.payment.domain.repository

import com.example.demo.payment.domain.model.Customer

interface CustomerRepository {
    fun findActiveCustomers(): List<Customer>
}