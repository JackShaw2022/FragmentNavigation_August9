package com.example.fragmentnavigation_august9

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(name: String) {
    Toast.makeText(requireContext(), "My name is $name", Toast.LENGTH_LONG).show()
}