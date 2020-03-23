package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.IntegerHasValue

/***
 * Validate Integer has a value.
 */
class IntNotEmptyValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<Int> {
    override val listOfRules = listOf(IntegerHasValue())
    override var success = false
}