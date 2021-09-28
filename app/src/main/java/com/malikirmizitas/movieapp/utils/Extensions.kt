package com.malikirmizitas.movieapp.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toastShort(messageToShow: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), messageToShow, duration).show()
}

fun Fragment.toastLong(messageToShow: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(requireContext(), messageToShow, duration).show()
}