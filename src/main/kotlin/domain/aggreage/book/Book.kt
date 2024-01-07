package domain.aggreage.book

import domain.aggreage.book.valueobject.Author
import domain.aggreage.book.valueobject.Name
import java.lang.IllegalArgumentException

class Book private constructor(){

    lateinit var bookName:Name;
    lateinit var authorName: Author


    constructor(bookName: Name,authorName: Author): this(){
        this.bookName = bookName
        this.authorName = authorName
    }

    companion object{
        fun makeNew(name:String,authorName:String) : Result<Book>{

            val resultName = Name.makeNew(name)

            val resultAuthor = Author.makeNew(authorName)
            return if (resultName.isSuccess && resultAuthor.isSuccess){
                Result.success(Book(resultName.getOrNull()!!,resultAuthor.getOrNull()!!))
            }else if(resultName.isFailure){
                Result.failure(Name.InvalidNameOfBookException("invalid name"))
            } else if (resultAuthor.isFailure){
                Result.failure(Author.InvalidAuthorName("invalid Author name"))
            }else{
                Result.failure(IllegalArgumentException("unrecognizable Error"))
            }

        }
    }
}