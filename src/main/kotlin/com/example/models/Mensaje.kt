package com.example.models

import kotlinx.serialization.Serializable
var mensajeGuardado : Mensaje? = null

@Serializable
data class Mensaje(
    val mensaje: String,
    )