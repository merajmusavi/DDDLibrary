package domain.aggreage.book

import com.example.dddlibrary.BookDataModel
import domain.aggreage.book.valueobject.Author
import domain.aggreage.book.valueobject.Name


class Book private constructor(){

    lateinit var bookName:Name;
    lateinit var authorName: Author


    constructor(bookName: Name,authorName: Author): this(){
        this.bookName = bookName
        this.authorName = authorName
    }

    companion object{

        fun makeNew(name:String,authorName:String) : Result<Book>?{

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

        fun fromDataModel(dataModel: BookDataModel) : Book{
            val bookNameResult = Name.makeNew(dataModel.name ?: throw Name.InvalidNameOfBookException("invalid name exception"))
            val authorNameResult = Author.makeNew(dataModel.authorName ?: throw Author.InvalidAuthorName("invalid author name"))


            if (bookNameResult.isSuccess && authorNameResult.isSuccess){
                return Book(bookNameResult.getOrNull()!!,authorNameResult.getOrNull()!!)

            }else{
                throw java.lang.IllegalArgumentException("unrecognizable error")
            }
        }
        class NotFoundException(message:String) : IllegalArgumentException(message)

    }
}