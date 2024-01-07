package domain.aggreage.book.valueobject

data class Name private constructor(val value: String){
    companion object{
        private fun isValidName(name:String):Boolean{
            val nameRegex = """^[a-zA-Z0-9\s]{2,50}$""".toRegex()
            return name.matches(nameRegex)
        }

        fun makeNew(name:String):Result<Name>{
            return if (isValidName(name)){
                Result.success(Name(name))
            }else{
                Result.failure(InvalidNameOfBookException("invalid Book Exception"))
            }
        }
    }
    class InvalidNameOfBookException(message:String) : Exception(message)
}