package hu.familyfinances.validatortilla.rules

import hu.familyfinances.validatortilla.R
import hu.familyfinances.validatortilla.model.BankAccountNumber

/***
 * Rule for Bank account validation.
 */
class BankAccountRule(
    override val errorMessage: Int = R.string.bank_account_failed
) : Rule<BankAccountNumber> {

    companion object {
        private const val ACCOUNT_SEGMENT_LONG = 8
        private const val ACCOUNT_SEGMENT_NULL = 0
    }

    override fun isValid(param: BankAccountNumber): Boolean {
        return param.segment1.length == ACCOUNT_SEGMENT_LONG && param.segment2.length == ACCOUNT_SEGMENT_LONG
                && (param.segment3.length == ACCOUNT_SEGMENT_NULL || param.segment3.length == ACCOUNT_SEGMENT_LONG)
    }
}
