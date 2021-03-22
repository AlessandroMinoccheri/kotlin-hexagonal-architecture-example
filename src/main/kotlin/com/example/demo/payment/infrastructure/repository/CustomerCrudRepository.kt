package com.example.demo.payment.infrastructure.repository

import com.example.demo.payment.domain.model.Customer
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerCrudRepository : CrudRepository<Customer, String> {
    @Query("select * from customers", nativeQuery = true)
    fun findActiveCustomers(): List<Customer>
}