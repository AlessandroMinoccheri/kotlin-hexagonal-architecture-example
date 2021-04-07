package com.example.demo.payment.domain.model

class Customer(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = ""
){
    override fun toString(): String{
        return "Customer[id=${id}, firstName=${firstName}, lastName=${lastName}]"
    }

    fun calculateRating(): Int{
        return 0
    }

    companion object {
        fun create(id: String, firstName: String, lastName: String): Customer = Customer(id, firstName, lastName)
    }
}
