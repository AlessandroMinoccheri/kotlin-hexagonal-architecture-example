package com.example.demo.payment.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CustomerTests {

    @Test
    fun itShouldCreateCustomer() {
        val customer = Customer.createTransient("foo", "bar")

        assertEquals("Customer[id=1, firstName=foo, lastName=bar]", customer.toString())
    }

}