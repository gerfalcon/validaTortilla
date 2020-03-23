package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.ActiveEmployerTooLessRule
import hu.familyfinances.validatortilla.rules.Rule


/***
 * Validate active employer.
 */
class ActiveEmployerNumberValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<Int> {
    override val listOfRules: List<Rule<Int>> = listOf(ActiveEmployerTooLessRule())
    override var success = false
}