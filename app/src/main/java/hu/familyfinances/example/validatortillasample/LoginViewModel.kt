package hu.familyfinances.example.validatortillasample

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.familyfinances.example.validatortillasample.common.default
import hu.familyfinances.validatortilla.rules.EmailRule
import hu.familyfinances.validatortilla.rules.PasswordRule
import hu.familyfinances.validatortilla.rules.UsernameExistRule
import hu.familyfinances.validatortilla.validators.NameValidator
import hu.familyfinances.validatortilla.validators.PasswordValidator

class LoginViewModel() : ViewModel() {

    val username: String = ""
    val password: String = ""

    val runValidate: MutableLiveData<Boolean> = MutableLiveData<Boolean>().default(false)

    private val usernameExistRule = UsernameExistRule()
    val nameValidator = NameValidator(usernameExistRule)
    val passwordValidator = PasswordValidator(listOf(PasswordRule()))

    fun onRegisterClicked() {
        runValidate.value = true
        if (nameValidator.success
            && passwordValidator.success
        ) {
            Log.d("VALIDATION", "Success validation")
        }
    }
}