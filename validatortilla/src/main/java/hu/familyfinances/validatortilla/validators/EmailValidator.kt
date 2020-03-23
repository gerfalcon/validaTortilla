package hu.familyfinances.validatortilla.validators


import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.EmailRule
import hu.familyfinances.validatortilla.rules.Rule

/***
 * Email validator.
 */
class EmailValidator(
    override val successMessage: Int = R.string.email_is_valid
) : Validator<String> {
    override val listOfRules: List<Rule<String>>
        get() = listOf(EmailRule())
    override var success: Boolean = false
}