package hu.familyfinances.validatortilla.rules

/***
 * Interface of Rule.
 */
interface Rule<T> {

    val errorMessage: Int

    fun isValid(param: T): Boolean
}