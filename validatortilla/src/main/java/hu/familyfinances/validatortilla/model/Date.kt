package hu.familyfinances.validatortilla.model

/***
 * Own class for represent Date.
 */
data class Date(val year: String = "", val month: String = "", val day: String = "") {

    fun toNormalDateString(): String? {
        return if (year.isNotBlank() && month.isNotBlank() && day.isNotBlank()) {
            "$year-$month-$day"
        } else {
            null
        }
    }
}