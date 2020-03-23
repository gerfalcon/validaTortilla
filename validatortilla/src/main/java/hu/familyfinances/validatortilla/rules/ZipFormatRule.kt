package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import java.util.regex.Pattern

/***
 * Rule for Zip code validation.
 */
class ZipFormatRule(
    override val errorMessage: Int = R.string.zip_format_failed
) : Rule<String> {

    override fun isValid(param: String): Boolean {
        return Pattern.compile("\\d{4}").matcher(param).matches()
    }
}