package com.example.demo.payment.application.service

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.infrastructure.repository.CustomerCrudRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val db: CustomerCrudRepository) {
    fun findCustomers(): List<Customer> {
        return db.findActiveCustomers()
    }

    fun save (customer: Customer) {
        db.save(customer)
    }
}
