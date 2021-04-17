package com.example.demo.payment.infrastructure.repository

import com.example.demo.payment.domain.model.Customer
import com.example.demo.payment.domain.repository.CustomerRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.UUID

object Customers : Table() {
    val id = varchar("id", 60)
    val firstName = varchar("firstName", 200)
    val lastName = varchar("lastName", 200)
    override val primaryKey = PrimaryKey(id)
}

const val DB_NAME = "jdbc:h2:file:~/h2/testdb3"

@Repository
class CustomerRepositoryH2 : CustomerRepository {

    init {
        Database.connect(DB_NAME, driver = "org.h2.Driver", user = "sa", password = "password")
        transaction {
            SchemaUtils.create(Customers)
        }
    }

    override fun findAllCustomers(): List<Customer> {
        return transaction {
            Customers
                .selectAll()
                .map { resultRow ->
                    Customer.create(
                        id = resultRow[Customers.id],
                        firstName = resultRow[Customers.firstName],
                        lastName = resultRow[Customers.lastName]
                    )
                }
        }
    }

    private fun uuid(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

    override fun save(customer: Customer): Customer {

        val customerWithId = customer.withId(uuid())

        transaction {
            Customers.insert {
                it[id] = customerWithId.id
                it[lastName] = customerWithId.lastName
                it[firstName] = customerWithId.firstName
            }
        }

        return customerWithId

    }
}