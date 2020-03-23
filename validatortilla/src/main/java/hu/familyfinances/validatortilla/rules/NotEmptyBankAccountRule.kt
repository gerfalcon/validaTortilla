package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.BankAccountNumber

/***
 * Rule for empty bank account validation.
 */
class NotEmptyBankAccountRule(
    override val errorMessage: Int = R.string.bank_account_failed
) : Rule<BankAccountNumber> {

    override fun isValid(param: BankAccountNumber): Boolean {
        return param.segment1.isNotEmpty() && param.segment2.isNotEmpty()
    }
}
