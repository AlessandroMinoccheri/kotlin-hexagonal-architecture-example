package com.example.demo.payment.domain.model

data class Customer private constructor(
    val id: String = "",
    val firstName: String,
    val lastName: String
){
    override fun toString(): String{
        return "Customer[id=${id}, firstName=${firstName}, lastName=${lastName}]"
    }

    fun calculateRating(): Int{
        //business logic
        return 0
    }

    fun withId(id: String): Customer {
        return copy(id = id);
    }

    companion object {
        fun create(id: String, firstName: String, lastName: String): Customer = Customer(id, firstName, lastName)
        fun createTransient(firstName: String, lastName: String): Customer = Customer(
            firstName = firstName,
            lastName = lastName
        )
    }
}
