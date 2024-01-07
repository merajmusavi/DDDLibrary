package com.example.dddlibrary

import org.springframework.stereotype.Service

@Service
class Service(val repo:DbInt) {

    fun insertBook(book:BookDataModel){
        repo.save(book)
    }
}