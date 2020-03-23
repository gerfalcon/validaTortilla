package hu.familyfinances.example.validatortillasample.adapter

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import hu.familyfinances.example.validatortillasample.view.InputFieldView
import hu.familyfinances.validatortilla.validators.Validator

object InputFieldViewBindingAdapter {

    @BindingAdapter("validator")
    @JvmStatic
    fun addValidator(inputFieldView: InputFieldView, validator: Validator<String>) {
        inputFieldView.validator = validator
    }

    @BindingAdapter("text")
    @JvmStatic
    fun setText(inputFieldView: InputFieldView, text: String) {
        if (inputFieldView.getText() != text) {
            inputFieldView.setText(text)
        }
    }

    @InverseBindingAdapter(attribute = "text", event = "textAttrChanged")
    @JvmStatic
    fun getText(inputFieldView: InputFieldView): String {
        return inputFieldView.getText()
    }

    @BindingAdapter("textAttrChanged")
    @JvmStatic
    fun setupListener(inputFieldView: InputFieldView, listener: InverseBindingListener) {
        inputFieldView.addTextWatcher(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                listener.onChange()
            }

            override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    @BindingAdapter("runValidate")
    @JvmStatic
    fun runValidate(inputFieldView: InputFieldView, runValidate: Boolean) {
        if (runValidate) {
            inputFieldView.validate()
        }
    }

    @BindingAdapter("addTextChangedListener")
    @JvmStatic
    fun addTextChangeListener(inputFieldView: InputFieldView, textWatcher: TextWatcher) {
        inputFieldView.addTextWatcher(textWatcher)
    }

}