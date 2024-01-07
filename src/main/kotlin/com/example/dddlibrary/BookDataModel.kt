package com.example.dddlibrary

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.*
import javax.annotation.processing.Generated

@Entity(name = "bookDbb")
@Table(name = "bookDbb")
data class BookDataModel (

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    val id:Long? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name= "authorName")
    val authorName: String? = null


)