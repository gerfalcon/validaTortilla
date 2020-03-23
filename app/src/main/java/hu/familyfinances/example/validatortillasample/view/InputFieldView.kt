package hu.familyfinances.example.validatortillasample.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import hu.familyfinances.example.validatortillasample.R
import hu.familyfinances.validatortilla.validators.Validator
import kotlinx.android.synthetic.main.input_field_view.view.*

/***
 * InputField in the application.
 */
class InputFieldView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private var focusColor: Int = Color.BLACK
    private var inActiveColor: Int = Color.GRAY
    private var errorColor: Int = Color.RED
    private var successColor: Int = Color.GREEN
    private var iconResId: Int = 0
    private var focusedBox: Int = 0
    private var inActiveBox: Int = 0
    private var errorBox: Int = 0
    private var successBox: Int = 0
    private var feedbackGone = false
    private var togglePassword = false
    private var maxLength: Int = -1
    private var placeholderResId: Int = 0
    private var isLastAction: Boolean = false

    var validator: Validator<String>? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.input_field_view, this, true)

        attrs?.let { attributeSet ->
            val typedArray =
                context.obtainStyledAttributes(attributeSet, R.styleable.InputFieldView, 0, 0)

            val hintLabel = resources.getText(
                typedArray.getResourceId(
                    R.styleable.InputFieldView_hint_label,
                    0
                )
            )
            val textColor = getColor(typedArray, R.styleable.InputFieldView_text_color, Color.BLACK)
            focusColor = getColor(typedArray, R.styleable.InputFieldView_color_focused, Color.BLACK)
            inActiveColor =
                getColor(typedArray, R.styleable.InputFieldView_color_inactive, Color.GRAY)
            errorColor = getColor(typedArray, R.styleable.InputFieldView_color_error, Color.RED)
            successColor =
                getColor(typedArray, R.styleable.InputFieldView_color_success, Color.GREEN)
            iconResId = typedArray.getResourceId(R.styleable.InputFieldView_icon, -1)
            focusedBox = typedArray.getResourceId(R.styleable.InputFieldView_border_focus, -1)
            inActiveBox = typedArray.getResourceId(R.styleable.InputFieldView_border_inactive, -1)
            errorBox = typedArray.getResourceId(R.styleable.InputFieldView_border_error, -1)
            successBox = typedArray.getResourceId(R.styleable.InputFieldView_border_success, -1)
            val inputType =
                typedArray.getInt(R.styleable.InputFieldView_inputType, InputType.TYPE_CLASS_TEXT)
            feedbackGone = typedArray.getBoolean(R.styleable.InputFieldView_feedbackGone, false)
            maxLength = typedArray.getInt(R.styleable.InputFieldView_maxLength, -1)
            placeholderResId = typedArray.getResourceId(R.styleable.InputFieldView_placeholder, -1)
            isLastAction = typedArray.getBoolean(R.styleable.InputFieldView_lastAction, false)
            setMaximumLength(maxLength)
            hint.text = hintLabel ?: ""
            edit_text.setTextColor(textColor)
            edit_text.inputType = inputType
            if (iconResId > 0) {
                image_in_box.setImageResource(iconResId)

                if (togglePassword) {
                    image_in_box.setOnClickListener {
                        if (edit_text.transformationMethod != null) {
                            edit_text.transformationMethod = null
                        } else {
                            edit_text.transformationMethod = PasswordTransformationMethod()
                        }
                    }
                }

            }

            if (placeholderResId > 0) {
                edit_text.setHint(placeholderResId)
            }

            if (isLastAction) {
                edit_text.imeOptions = EditorInfo.IME_ACTION_DONE
            }


            drawInactive()
            edit_text.setOnFocusChangeListener { _, hasFocus ->
                run {
                    if (hasFocus) {
                        drawFocused()
                    } else {
                        validate()
                    }
                }
            }

            typedArray.recycle()
        }
    }

    fun validate() {
        val resultOf = validator?.validate(getText())
        if (resultOf == null) {
            drawInactive()
        } else if (!resultOf.isValid) {
            drawError(resultOf.resultResId)
        } else {
            drawSuccess(resultOf.resultResId)
        }
    }

    fun getText() = edit_text.text.toString()

    fun setText(text: String) {
        edit_text.setText(text)
        validate()
    }

    fun addTextWatcher(textWatcher: TextWatcher) {
        edit_text.addTextChangedListener(textWatcher)
    }

    fun setMaximumLength(maxLength: Int) {
        this.maxLength = maxLength
        if (maxLength >= 0) {
            edit_text.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        }
    }

    private fun setHintColor(color: Int) {
        hint.setTextColor(color)
    }

    private fun setHintFontType(fontType: Int) {
        val typeFace = ResourcesCompat.getFont(context, fontType)
        hint.typeface = typeFace
    }

    private fun setBorder(borderResId: Int) {
        box.background = AppCompatResources.getDrawable(context, borderResId)
    }

    private fun tintIcon(color: Int) {
        if (iconResId > 0) {
            DrawableCompat.setTint(image_in_box.drawable.mutate(), color)
        }
    }

    private fun setFeedbackIcon(feedbackIcon: Int, tintColor: Int) {
        val errorIcon = AppCompatResources.getDrawable(context, feedbackIcon)
        errorIcon?.let { icon ->
            DrawableCompat.setTint(icon.mutate(), tintColor)
            feedback_icon.setImageDrawable(icon)
        }
    }

    private fun setFeedbackMessage(messageResId: Int) {
        if (messageResId > 0) {
            feedback_text.setText(messageResId)
        }
    }

    private fun hideFeedback() {
        if (feedbackGone) {
            feedback_icon.visibility = View.GONE
            feedback_text.visibility = View.GONE
        } else {
            feedback_icon.visibility = View.INVISIBLE
            feedback_text.visibility = View.INVISIBLE
        }
    }

    private fun showFeedback() {
        if (feedbackGone) {
            feedback_icon.visibility = View.GONE
            feedback_text.visibility = View.GONE
        } else {
            feedback_icon.visibility = View.VISIBLE
            feedback_text.visibility = View.VISIBLE
        }
    }

    override fun setOnFocusChangeListener(listener: OnFocusChangeListener) {
        edit_text.onFocusChangeListener = listener
    }

    private fun getColor(typedArray: TypedArray, styleableResId: Int, defaultColor: Int): Int {
        return typedArray.getColor(styleableResId, defaultColor)
    }

    private fun drawInactive() {
        hideFeedback()
        setBorder(inActiveBox)
        drawWithColor(inActiveColor)
    }

    private fun drawFocused() {
        hideFeedback()
        setBorder(focusedBox)
        drawWithColor(focusColor)
    }

    private fun drawError(feedbackMessageResId: Int) {
        if (feedbackMessageResId > 0) {
            setupFeedback(R.drawable.ic_error, errorColor, feedbackMessageResId)
            showFeedback()
        }
        setBorder(errorBox)
        drawWithColor(errorColor)
    }

    private fun drawSuccess(feedbackMessageResId: Int) {
        if (feedbackMessageResId > 0) {
            setupFeedback(R.drawable.ic_success, successColor, feedbackMessageResId)
            showFeedback()
        }
        setBorder(successBox)
        drawWithColor(successColor)
    }

    private fun setupFeedback(feedbackIcon: Int, tintColor: Int, messageResId: Int) {
        setFeedbackIcon(feedbackIcon, tintColor)
        setFeedbackMessage(messageResId)
    }

    private fun drawWithColor(color: Int) {
        setHintColor(color)
        tintIcon(color)
    }
}