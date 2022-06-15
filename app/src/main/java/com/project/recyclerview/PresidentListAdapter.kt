package com.project.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recyclerview.databinding.ItemListPresidentBinding

class PresidentListAdapter: RecyclerView.Adapter<PresidentListAdapter.ViewHolder>() {

    private var listener: ((PresidentModel) -> Unit)? = null


    var presidents = mutableListOf<PresidentModel>()
    set(value) {
        val callback = DivCallbackPresident(field, value)
        val result = DiffUtil.calculateDiff(callback)
        field.clear()
        field.addAll(value)
        result.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding:  ItemListPresidentBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(president: PresidentModel) {

            val id = itemView.context.resources.getIdentifier(
                president.poster,
                "drawable",
                itemView.context.packageName
            )

            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(id)
                    .placeholder(android.R.color.darker_gray)
                    .into(imgPoster)

                tvName.text = president.name

                listener?.let {
                    itemView.setOnClickListener {
                        it(president)
                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ItemListPresidentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(presidents[position])
    }

    override fun getItemCount(): Int = presidents.size

    fun onClick(listener: ((PresidentModel) -> Unit)?){
        this.listener = listener
    }
}