package com.poc.network.home.presentation


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.poc.network.R
import com.poc.network.databinding.ActivityMainBinding
import com.poc.network.home.presentation.adapter.MovieAdapter
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by inject()

    private var adapter: MovieAdapter? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerViewTop.visibility = View.GONE
        setContentView(binding.root)

        homeViewModel.getMoviesComic()

        setupScreen()
    }

    private fun setupScreen() {
        homeViewModel.liveDataMoviesPopular.observe(this, Observer {
            binding.recyclerViewTop.apply {
                adapter = MovieAdapter(it.listMovies,this@MainActivity,R.layout.movie_item)
                layoutManager = GridLayoutManager(this@MainActivity,2)
                visibility = View.VISIBLE
            }
        })
    }
}