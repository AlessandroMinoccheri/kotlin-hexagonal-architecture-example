package com.example.demo.payment.domain.repository

import com.example.demo.payment.domain.model.Customer

interface CustomerRepository {
    fun findAllCustomers(): List<Customer>
    fun save(customer: Customer)
}
