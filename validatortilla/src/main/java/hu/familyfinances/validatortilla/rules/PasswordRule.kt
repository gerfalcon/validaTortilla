package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import java.util.regex.Pattern

/***
 * Rule for password validation.
 */
class PasswordRule(override var errorMessage: Int = R.string.password_length_validation_failed) : Rule<String> {

    override fun isValid(param: String): Boolean {
        return Pattern.compile("^(?=.*[a-z])(?=.*[$@$#!%*?&-_.:;'])[A-Za-z\\d$@$#!%*?&-_.:;']{8,}")
            .matcher(param).matches()
    }
}