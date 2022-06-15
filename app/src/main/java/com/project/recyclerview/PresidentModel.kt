package com.project.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PresidentModel(
    val poster: String,
    val name: String,
    val desc: String
): Parcelable
