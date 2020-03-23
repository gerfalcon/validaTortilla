package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import java.util.regex.Pattern

/***
 * Mobile phone number format rule.
 */
class MobileNumberFormatRule(
    override val errorMessage: Int = R.string.phone_number_format_failed
) : Rule<String> {

    override fun isValid(param: String): Boolean {
        return Pattern.compile("^\\+36\\d{9}").matcher(param).matches()
    }
}