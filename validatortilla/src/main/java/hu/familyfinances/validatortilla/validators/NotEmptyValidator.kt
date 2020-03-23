package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.NotEmptyRule
import hu.familyfinances.validatortilla.rules.Rule

/***
 * Validate field is not empty.
 */
class NotEmptyValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<String> {
    override val listOfRules: List<Rule<String>> = listOf(NotEmptyRule())
    override var success: Boolean = false
}