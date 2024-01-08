package com.example.dddlibrary

import Exception.BookNotFoundException
import domain.aggreage.book.Book
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class Service(val repo:DbInt) {

    fun insertBook(book:BookDataModel){
        repo.save(book)
    }

    fun findByName(name:String): ResponseEntity<Any> {
        return try {
            val findByName = repo.findByName(name) ?: throw Book.Companion.NotFoundException("not found exception") //bookdatamodel

            val book = Book.fromDataModel(findByName)


            ResponseEntity.ok(book)

        }catch (e : Book.Companion.NotFoundException){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found")
        }catch (e: Exception){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("un recognizable error")
        }

    }
}