package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.AdultsNumberTooLessRule
import hu.familyfinances.validatortilla.rules.Rule


/***
 * Validate adults number.
 */
class AdultsNumberValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<Int> {
    override val listOfRules: List<Rule<Int>> = listOf(AdultsNumberTooLessRule())
    override var success = false
}