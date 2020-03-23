package hu.familyfinances.example.validatortillasample.adapter

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import hu.familyfinances.example.validatortillasample.common.setSafeOnClickListener

object TextViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("textResource")
    fun setupTextResourceId(textView: TextView, textResourceId: Int) {
        textView.setText(textResourceId)
    }

    @JvmStatic
    @BindingAdapter("onSafeClick")
    fun setupSafeClickListener(textView: TextView, clickListener: View.OnClickListener) {
        textView.setSafeOnClickListener { clickListener.onClick(textView) }
    }
}