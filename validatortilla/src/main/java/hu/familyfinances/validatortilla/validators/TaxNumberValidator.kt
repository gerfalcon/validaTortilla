package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.NotEmptyRule
import hu.familyfinances.validatortilla.rules.TaxNumberRule

/***
 * Validate TaxNumber.
 */
class TaxNumberValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<String> {
    override val listOfRules = listOf(NotEmptyRule(), TaxNumberRule())
    override var success = false
}