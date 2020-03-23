package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import java.util.regex.Pattern

/***
 * Validator rule to check TaxNumber.
 */
class TaxNumberRule(
    override val errorMessage: Int = R.string.tax_id_format_failed
) : Rule<String> {
    override fun isValid(param: String): Boolean {
        return Pattern.compile("^8\\d{9}").matcher(param).matches()
    }
}