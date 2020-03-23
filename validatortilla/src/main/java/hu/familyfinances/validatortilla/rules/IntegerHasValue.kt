package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R

/***
 * Check Integer value greater than zero.
 */
class IntegerHasValue(override val errorMessage: Int = R.string.not_empty_failed) : Rule<Int> {

    override fun isValid(param: Int): Boolean {
        return param >= 0
    }
}