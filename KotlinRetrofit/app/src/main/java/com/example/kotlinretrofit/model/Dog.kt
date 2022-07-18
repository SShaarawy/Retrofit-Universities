package com.example.kotlinretrofit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class Dog  (
    val web_pages : List<String>,
    val name : String,
    val alpha_two_code : String,
    val state_province : String?,
    val domains : List<String>,
    val country : String
    ) : Serializable