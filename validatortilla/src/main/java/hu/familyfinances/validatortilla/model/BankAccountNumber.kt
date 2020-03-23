package hu.familyfinances.validatortilla.model

data class BankAccountNumber(var segment1: String = "", var segment2: String = "", var segment3: String = "") {

    fun getFormattedValue() = "$segment1 - $segment2 - $segment3"

    fun getUnformattedValue() = segment1 + segment2 + segment3

    companion object {
        @JvmStatic
        fun fromString(accountNumber: String): BankAccountNumber {

            return BankAccountNumber(
                accountNumber.replace("-", "").substring(0, 8),
                accountNumber.replace("-", "").substring(8, 16),
                accountNumber.replace("-", "").substring(16, accountNumber.length)
            )
        }
    }
}