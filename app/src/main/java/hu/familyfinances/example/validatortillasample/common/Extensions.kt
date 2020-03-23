package hu.familyfinances.example.validatortillasample.common

import android.view.View
import androidx.lifecycle.MutableLiveData

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun <T> MutableLiveData<T>.safeValue(default: T): T = value ?: default

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener { onSafeClick(it) }
    setOnClickListener(safeClickListener)
}