package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.Date

/***
 * Validate day format.
 */
class DayFormatRule(override val errorMessage: Int = R.string.date_format_not_valid) : Rule<Date> {

    companion object {
        private const val MIN_DAY = 1
        private const val MAX_DAY = 31
    }

    override fun isValid(param: Date): Boolean {
        val year = param.day.toIntOrNull() ?: 0
        return year in MIN_DAY..MAX_DAY
    }
}