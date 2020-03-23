package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R

/***
 * Rule for not empty.
 */
class NotEmptyRule(
    override val errorMessage: Int = R.string.not_empty_failed
) : Rule<String> {

    override fun isValid(param: String): Boolean {
        return param.isNotEmpty() && param.isNotBlank()
    }
}