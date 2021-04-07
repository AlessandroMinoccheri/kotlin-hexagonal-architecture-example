package com.example.demo.payment.infrastructure.repository

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.domain.repository.CustomerRepository
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class CustomerRepositoryJdbc constructor(private val customerRepository: NamedParameterJdbcTemplate): CustomerRepository {
    override fun findAllCustomers(): List<Customer> {
        val rowMapper: RowMapper<Customer> = RowMapper<Customer> { resultSet: ResultSet, rowIndex: Int ->
            Customer(resultSet.getString("id"), resultSet.getString("firstname"), resultSet.getString("lastname"))
        }

        return customerRepository.query("SELECT * FROM customers", rowMapper)
    }

    override fun save(customer: Customer) {
        val sql = """
            INSERT INTO customers (id, firstname, lastname)
            VALUES (:id, :firstName, :lastName)
        """.trimIndent()

        val keyHolder = GeneratedKeyHolder()
        customerRepository.update(sql,
            MapSqlParameterSource(mapOf(
                "id" to customer.id,
                "firstName" to customer.firstName,
                "lastName" to customer.lastName,
            )),
            keyHolder)
    }
}