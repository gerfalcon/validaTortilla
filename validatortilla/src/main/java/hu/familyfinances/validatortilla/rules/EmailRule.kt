package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R


/***
 * Email rule for check validation of given email.
 */
class EmailRule(override val errorMessage: Int = R.string.email_validation_failed) : Rule<String> {

    override fun isValid(param: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(param).matches()
    }
}