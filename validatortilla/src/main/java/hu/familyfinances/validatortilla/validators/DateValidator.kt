package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.Date
import hu.familyfinances.validatortilla.rules.DateRule
import hu.familyfinances.validatortilla.rules.DayFormatRule
import hu.familyfinances.validatortilla.rules.MonthFormatRule
import hu.familyfinances.validatortilla.rules.Rule
import hu.familyfinances.validatortilla.rules.YearFormatRule

/***
 * Date Format validator.
 */
class DateValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<Date> {
    override val listOfRules: List<Rule<Date>> = listOf(
        YearFormatRule(),
        MonthFormatRule(),
        DayFormatRule(),
        DateRule()
    )
    override var success: Boolean = false
}