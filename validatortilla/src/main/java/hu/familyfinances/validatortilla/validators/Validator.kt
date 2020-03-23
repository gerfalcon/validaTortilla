package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.rules.Rule

/***
 * Interface of Validator.
 */
interface Validator<T> {

    val listOfRules: List<Rule<T>>

    val successMessage: Int

    var success: Boolean

    fun validate(param: T): ValidatorResult {
        var result = ValidatorResult(true, successMessage)
        for (rule in listOfRules) {
            if (!rule.isValid(param)) {
                result = ValidatorResult(false, rule.errorMessage)
                break
            }
        }
        success = result.isValid
        return result
    }
}