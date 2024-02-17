package com.test.moviedbkoin.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.core.data.Resource
import com.test.core.extension.data
import com.test.core.extension.observeData
import com.test.domain.model.credentials.request.GeneralRequest
import com.test.moviedbkoin.databinding.ActivityDiscoverMovieBinding
import com.test.moviedbkoin.ui.home.HomeViewModel
import com.test.moviedbkoin.ui.movie.adapter.DiscoverMovieAdapter
import com.test.moviedbkoin.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiscoverMovieActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityDiscoverMovieBinding::inflate)
    private val homeViewModel: HomeViewModel by viewModel()
    private val discoverMovieAdapter by lazy {
        DiscoverMovieAdapter {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        homeViewModel.getMovie(
            GeneralRequest(
                page = 1,
                genre = intent.getIntExtra("id", 0).toString()
            )
        )
        observable()
    }

    private fun initView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRv.adapter = discoverMovieAdapter
    }

    private fun observable() {
        observeData(homeViewModel.movie) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        discoverMovieAdapter.submitList(result.data()?.results)
                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
    }
}