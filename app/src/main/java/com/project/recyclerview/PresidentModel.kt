package com.project.recyclerview

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class PresidentModel(
    val poster: String,
    val name: String,
    val desc: String
): Parcelable
