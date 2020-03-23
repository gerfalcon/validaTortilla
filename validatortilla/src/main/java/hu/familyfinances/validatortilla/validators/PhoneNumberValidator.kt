package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.MobileNumberFormatRule
import hu.familyfinances.validatortilla.rules.Rule

/***
 * Validator for PhoneNumbers.
 */
class PhoneNumberValidator(
    override val successMessage: Int = R.string.phone_number_is_valid
) : Validator<String> {
    override val listOfRules: List<Rule<String>>
        get() = listOf(MobileNumberFormatRule())
    override var success: Boolean = false
}