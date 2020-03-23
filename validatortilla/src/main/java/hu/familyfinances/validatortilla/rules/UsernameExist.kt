package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R

/***
 * Rule for username validation.
 */
class UsernameExistRule(
    override val errorMessage: Int = R.string.registration_username_exist
) : Rule<String> {
    val existUsers = ArrayList<String>()

    override fun isValid(param: String): Boolean {
        return !existUsers.contains(param)
    }
}