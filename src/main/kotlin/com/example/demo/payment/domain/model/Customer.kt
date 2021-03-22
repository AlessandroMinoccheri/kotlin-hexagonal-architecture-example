package com.example.demo.payment.domain.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
public class Customer(
    @Id
    val id: String = "",

    @Column(name = "firstname")
    val firstName: String = "",

    @Column(name = "lastname")
    val lastName: String = ""
){
    override fun toString(): String{
        return "Customer[id=${id}, firstName=${firstName}, lastName=${lastName}]"
    }
}