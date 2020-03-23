package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.NotEmptyRule
import hu.familyfinances.validatortilla.rules.Rule
import hu.familyfinances.validatortilla.rules.ZipFormatRule

/***
 * Validator class to validate Zip Code
 */
class ZipCodeValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<String> {
    override val listOfRules: List<Rule<String>> = listOf(
        NotEmptyRule(),
        ZipFormatRule()
    )
    override var success: Boolean = false
}