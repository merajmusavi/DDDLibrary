package domain.aggreage.book

import domain.aggreage.book.valueobject.Name

class Book private constructor(){

    lateinit var bookName:Name;


    constructor(bookName: Name): this(){
        this.bookName = bookName;
    }

    companion object{
        fun makeNew(name:String) : Result<Book>{

            val resultName = Name.makeNew(name)

            return if (resultName.isSuccess){
                Result.success(Book(resultName.getOrNull()!!))
            }else{
                Result.failure(Name.InvalidNameOfBookException("invalid name"))
            }

        }
    }
}