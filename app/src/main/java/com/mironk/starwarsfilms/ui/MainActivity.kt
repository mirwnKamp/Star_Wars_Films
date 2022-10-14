package com.mironk.starwarsfilms.ui


import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mironk.starwarsfilms.adapter.StarWarsClickListener
import com.mironk.starwarsfilms.adapter.StarWarsPagedAdapter
import com.mironk.starwarsfilms.databinding.ActivityMainBinding
import com.mironk.starwarsfilms.viewmodel.StarWarsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: StarWarsPagedAdapter
    private val viewModel: StarWarsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        loadingData()


    }



    private fun setupRV() {

        mAdapter = StarWarsPagedAdapter(StarWarsClickListener {
            Toast.makeText(this@MainActivity, "Touched the character's name",Toast.LENGTH_SHORT).show()
        })

        binding.rvCharacters.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = mAdapter
            setHasFixedSize(true)


        }

    }

    private fun loadingData() {

        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->

                mAdapter.submitData(pagingData)

            }
        }
    }
}