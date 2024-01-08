package com.example.dddlibrary

import domain.aggreage.book.Book
import domain.aggreage.book.valueobject.Author
import domain.aggreage.book.valueobject.Name
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class Controller(val serviceLayer: com.example.dddlibrary.Service) {

    @PostMapping()
    fun saveBook(@RequestBody book: BookDataModel): Any {


        try {
            var result = Book.makeNew(book.name.toString(), book.authorName.toString())
            if (result!!.isFailure) {
                throw result.exceptionOrNull()!!
            }



            serviceLayer.insertBook(book)


            return "inserted successfully"


        } catch (e: Name.InvalidNameOfBookException) {
            return "invalid name"
        } catch (e: Author.InvalidAuthorName) {
            return "invalid Author name"
        }


    }

    @PostMapping("find")
    fun findByName(@RequestBody map: Map<String,String>):ResponseEntity<Any>{

        return serviceLayer.findByName(map.get("name").toString());

    }

}