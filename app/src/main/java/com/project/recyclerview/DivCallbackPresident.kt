package com.project.recyclerview

import androidx.recyclerview.widget.DiffUtil

class DivCallbackPresident(private val oldPresidents: List<PresidentModel>, private val newPresidents: List<PresidentModel>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldPresidents.size

    override fun getNewListSize(): Int = newPresidents.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPresidents[oldItemPosition].name == newPresidents[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPresidents[oldItemPosition].name == newPresidents[newItemPosition].name
}