package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.Date
import java.util.*

/***
 * Rule of month format.
 */
class YearFormatRule(
    override val errorMessage: Int = R.string.date_format_not_valid
) : Rule<Date> {

    companion object {
        private const val MIN_YEAR = 1900
        private var MAX_YEAR = Calendar.getInstance().get(Calendar.YEAR)
    }

    override fun isValid(param: Date): Boolean {
        val year = param.year.toIntOrNull() ?: 0
        return year in MIN_YEAR..MAX_YEAR
    }
}