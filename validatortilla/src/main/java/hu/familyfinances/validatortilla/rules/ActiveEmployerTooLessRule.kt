package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R

/***
 * Rule for Active Employer Number validation.
 */
class ActiveEmployerTooLessRule( override val errorMessage: Int = R.string.active_employer_less_than_one) : Rule<Int> {

    override fun isValid(param: Int): Boolean {
        return param >= 1
    }
}