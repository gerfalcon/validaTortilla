package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.NotEmptyRule
import hu.familyfinances.validatortilla.rules.Rule
import hu.familyfinances.validatortilla.rules.SmsCodeRule

/***
 * SMS code validator.
 */
class SmsCodeValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<String> {
    override val listOfRules: List<Rule<String>>
        get() = listOf(NotEmptyRule(), SmsCodeRule())
    override var success: Boolean = false
}