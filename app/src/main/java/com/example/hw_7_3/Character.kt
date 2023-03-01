package com.example.hw_7_3

import java.io.Serializable

data class Character(
    val name: String,
    val status: String,
    val image: Int
) : Serializable
