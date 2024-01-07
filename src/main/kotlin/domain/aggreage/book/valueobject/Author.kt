package domain.aggreage.book.valueobject

import javax.print.DocFlavor.STRING

data class Author private constructor(val value:String){
    companion object{
        private fun isValidAuthorName(name:String):Boolean{
            val authorNameRegex = """^[a-zA-Z0-9\s]{2,50}$""".toRegex()
            return authorNameRegex.matches(name)



        }

        fun makeNew(authorName:String) : Result<Author>{
            return if (isValidAuthorName(authorName)){
                Result.success(Author(authorName))
            }else{
                Result.failure(InvalidAuthorName("invalid author name"))
            }
        }
    }
    class InvalidAuthorName(message:String) : IllegalArgumentException(message)
}