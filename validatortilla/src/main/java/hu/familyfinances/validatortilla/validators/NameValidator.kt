package hu.familyfinances.validatortilla.validators


import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.rules.NotEmptyRule
import hu.familyfinances.validatortilla.rules.Rule

/***
 * Name validator.
 */
class NameValidator(
    val rule: Rule<String>,
    override val successMessage: Int = R.string.empty_text
) : Validator<String> {
    override var success: Boolean = false
    override val listOfRules: List<Rule<String>>
        get() = listOf(NotEmptyRule(), rule)
}