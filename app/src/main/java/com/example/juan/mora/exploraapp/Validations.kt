package com.example.juan.mora.exploraapp

import android.util.Patterns


fun validateEmail(email: String): Pair<Boolean, String> {
    return when {
        email.isEmpty() -> Pair(false, "Escribe tu correo")
        !email.contains("@") -> Pair(false, "Correo no válido")
        else -> Pair(true, "")
    }
}



fun validatePassword(password: String): Pair<Boolean, String> {
    return when {
        password.isEmpty() -> Pair(false, "La contraseña es obligatoria.")

        password.length < 6 -> Pair(false, "La contraseña debe tener al menos 6 caracteres.")

        !password.any { it.isDigit() } -> Pair(false, "La contraseña debe contener al menos un número")

        else -> Pair(true, "")
    }
}

fun validateName(name: String): Pair<Boolean, String> {
    return when {
        name.isEmpty() -> Pair(false, "El nombre es obligatorio.")
        name.length < 3 -> Pair(false, "El nombre debe de contener mínimo 3 caracteres.")
        else -> Pair(true, "")
    }
}

fun validateConfirmPassword(password: String, confirmPassword: String): Pair<Boolean, String> =
    when {
        confirmPassword.isEmpty() -> Pair(false, "Debes confirmar la contraseña.")
        confirmPassword != password -> Pair(false, "Las contraseñas no coinciden.")
        else -> true to ""
    }