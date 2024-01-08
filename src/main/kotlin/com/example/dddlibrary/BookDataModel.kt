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
    var name: String? = null,

    @Column(name= "authorName")
    var authorName: String? = null


){
    constructor(name: String, author: String) : this(){
        this.name = name
        this.authorName = author
    }
}