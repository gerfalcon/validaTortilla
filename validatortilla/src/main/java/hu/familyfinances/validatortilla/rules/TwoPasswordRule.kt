package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R

/***
 * Rule for two password validation.
 */
class TwoPasswordRule(
    override val errorMessage: Int = R.string.two_passwords_equals_failed
) : Rule<String> {

    var basePass: String = ""

    override fun isValid(param: String): Boolean {
        return basePass == param
    }
}