package com.project.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: PresidentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Presidents of Indonesian"

        adapter = PresidentListAdapter().apply {
            onClick {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, it)
                startActivity(intent)
            }
        }

        setUpPresidentList()
    }

    private fun setUpPresidentList() {
        binding.apply {
            adapter.presidents = Repository.presidents as MutableList<PresidentModel>
            rvPresidents.setHasFixedSize(true)
            rvPresidents.adapter = adapter
        }
    }

}