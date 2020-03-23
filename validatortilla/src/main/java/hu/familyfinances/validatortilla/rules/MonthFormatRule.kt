package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.Date

/***
 * Rule of month format.
 */
class MonthFormatRule(
    override val errorMessage: Int = R.string.date_format_not_valid
) : Rule<Date> {

    companion object {
        private const val MIN_MONTH = 1
        private const val MAX_MONTH = 12
    }

    override fun isValid(param: Date): Boolean {
        val year = param.month.toIntOrNull() ?: 0
        return year in MIN_MONTH..MAX_MONTH
    }
}