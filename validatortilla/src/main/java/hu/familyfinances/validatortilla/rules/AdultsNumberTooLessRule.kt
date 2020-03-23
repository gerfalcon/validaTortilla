package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R

/***
 * Rule for Adults number validation.
 */
class AdultsNumberTooLessRule(
    override val errorMessage: Int = R.string.adults_number_less_than_one
) : Rule<Int> {

    override fun isValid(param: Int): Boolean {
        return param >= 1
    }
}