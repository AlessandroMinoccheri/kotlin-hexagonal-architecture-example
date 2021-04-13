package com.example.demo.payment.application.service

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.domain.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val db: CustomerRepository) {
    fun findAllCustomers(): List<Customer> {
        return db.findAllCustomers()
    }

    fun save (id: String, firstname: String, lastname: String) {
        val customer: Customer = Customer.create(id, firstname, lastname)

        db.save(customer)
    }
}
