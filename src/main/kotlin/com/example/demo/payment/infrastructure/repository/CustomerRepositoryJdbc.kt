package com.example.demo.payment.infrastructure.repository

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.domain.repository.CustomerRepository
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.UUID




@Repository
class CustomerRepositoryJdbc constructor(private val customerRepository: NamedParameterJdbcTemplate): CustomerRepository {
    override fun findAllCustomers(): List<Customer> {
        val rowMapper: RowMapper<Customer> = RowMapper<Customer> { resultSet: ResultSet, rowIndex: Int ->
            Customer.create(resultSet.getString("id"), resultSet.getString("firstname"), resultSet.getString("lastname"))
        }

        return customerRepository.query("SELECT * FROM customers", rowMapper)
    }

    private fun uuid() :String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

    override fun save(customer: Customer): Customer {

        val customerWithId = customer.withId(uuid())

        val sql = """
            INSERT INTO customers (id, firstname, lastname)
            VALUES (:id, :firstName, :lastName)
        """.trimIndent()

        val keyHolder = GeneratedKeyHolder()
        customerRepository.update(sql,
            MapSqlParameterSource(mapOf(
                "id" to customerWithId.id,
                "firstName" to customerWithId.firstName,
                "lastName" to customerWithId.lastName,
            )),
            keyHolder)

        return customerWithId

    }
}