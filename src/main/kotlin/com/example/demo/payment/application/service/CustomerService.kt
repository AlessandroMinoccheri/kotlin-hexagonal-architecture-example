package com.example.demo.payment.application.service

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.infrastructure.repository.CustomerRepository

class CustomerService(private val db: CustomerRepository) {
    fun findAllCustomers(): List<Customer> {
        return db.findAllCustomers()
    }

    fun save (firstname: String, lastname: String): Customer {
        val customer: Customer = Customer.createTransient(firstname, lastname)

        return db.save(customer)
    }
}
