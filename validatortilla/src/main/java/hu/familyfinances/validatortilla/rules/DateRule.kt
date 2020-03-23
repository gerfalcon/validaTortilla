package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.Date


/***
 * Validator rule for check Date.
 */
class DateRule(override val errorMessage: Int = R.string.date_format_not_valid) : Rule<Date> {
    companion object {
        private val DAYS_OF_MONTH = 1..31
        private val MONTH_OF_YEAR = 1..12
        private val DAYS_OF_FEBRUARY = 1..28
        private const val MIN_YEAR = 1900
        private const val APRIL = 4
        private const val JUNE = 6
        private const val SEPTEMBER = 9
        private const val OCTOBER = 11
        private const val FEBRUARY = 2
        private const val MAX_DAY_OF_MONTH = 31
        private const val LEAP_DAY_OF_FEBRUARY = 29
        private const val LEAP_YEAR_PERIOD = 4
        private const val HUNDRED_YEAR = 100
        private const val FOUR_HUNDRED = 400
    }

    override fun isValid(param: Date): Boolean {
        val year = param.year.toIntOrNull() ?: 0
        val day = param.day.toIntOrNull() ?: 0
        val month = param.month.toIntOrNull() ?: 0

        var result: Boolean = day in DAYS_OF_MONTH && month in MONTH_OF_YEAR && year > MIN_YEAR
        if (result) {
            when (month) {
                APRIL, JUNE, SEPTEMBER, OCTOBER -> result = day < MAX_DAY_OF_MONTH
                FEBRUARY -> result = checkFebruary(year, day)
            }
        }
        return result
    }

    private fun checkFebruary(year: Int, day: Int): Boolean {
        return when (day) {
            in DAYS_OF_FEBRUARY -> true
            LEAP_DAY_OF_FEBRUARY -> isLeapYear(year)
            else -> false
        }
    }

    private fun isLeapYear(year: Int): Boolean {
        return if (year % LEAP_YEAR_PERIOD == 0) {
            if (year % HUNDRED_YEAR == 0) {
                year % FOUR_HUNDRED == 0
            } else {
                true
            }
        } else {
            false
        }
    }
}