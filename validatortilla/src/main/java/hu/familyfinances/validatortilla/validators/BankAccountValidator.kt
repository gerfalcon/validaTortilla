package hu.familyfinances.validatortilla.validators

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.BankAccountNumber
import hu.familyfinances.validatortilla.rules.BankAccountRule
import hu.familyfinances.validatortilla.rules.NotEmptyBankAccountRule
import hu.familyfinances.validatortilla.rules.Rule


/***
 * Validator class for BankAccount
 */
class BankAccountValidator(
    override val successMessage: Int = R.string.empty_text
) : Validator<BankAccountNumber> {
    override val listOfRules: List<Rule<BankAccountNumber>> =
        listOf(NotEmptyBankAccountRule(), BankAccountRule())
    override var success: Boolean = false
}
