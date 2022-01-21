package com.example.fragmentnavigation_august9

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.convertToString(): String {
    return this.editText?.text.toString() ?: "No input"
}