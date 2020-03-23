package hu.familyfinances.validatortilla.rules


import hu.familyfinances.validatortilla.R
import java.util.regex.Pattern

/***
 * Mobile phone number format rule.
 */
class SmsCodeRule(
    override val errorMessage: Int = R.string.sms_code_validation_failed
) : Rule<String> {

    override fun isValid(param: String): Boolean {
        return Pattern.compile("^\\d{3}\\-\\d{3}").matcher(param).matches()
    }
}