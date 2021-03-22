package com.example.demo.payment.infrastructure.repository

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.domain.repository.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryH2 constructor(private val crud: CustomerCrudRepository): CustomerRepository {
    override fun findActiveCustomers(): List<Customer> {
       return crud.findActiveCustomers()
    }
}