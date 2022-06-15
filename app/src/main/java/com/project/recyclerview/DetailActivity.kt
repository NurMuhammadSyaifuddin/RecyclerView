package com.project.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail"

        getDetailPresident()
    }

    private fun getDetailPresident() {
        binding.apply {
            val president = intent?.extras?.getParcelable<PresidentModel>(EXTRA_DATA)

            val id = resources.getIdentifier(president?.poster.toString(), "drawable", packageName)

            Glide
                .with(this@DetailActivity)
                .load(id)
                .placeholder(android.R.color.darker_gray)
                .into(imgPoster)

            tvName.text = president?.name.toString()
            tvDesc.text = president?.desc.toString()
        }
    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}