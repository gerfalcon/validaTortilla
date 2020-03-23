package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.Rule

/***
 * Password validator.
 */
open class PasswordValidator(
    override val listOfRules: List<Rule<String>>,
    override val successMessage: Int = R.string.empty_text
) : Validator<String> {
    override var success: Boolean = false
}