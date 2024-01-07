package com.example.dddlibrary

import domain.aggreage.book.Book
import domain.aggreage.book.valueobject.Name
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val serviceLayer: com.example.dddlibrary.Service) {

    @PostMapping()
    fun saveBook(@RequestBody book : BookDataModel):Any{


        try {
            var result = Book.makeNew(book.name.toString())
            if(result.isFailure){
                throw result.exceptionOrNull()!!
            }

            val bookNameResult = result.getOrNull()!!.bookName.value


            serviceLayer.insertBook(book)


            return "inserted successfully"


        }catch (e: Name.InvalidNameOfBookException){
            return "invalid name"
        }





    }


}