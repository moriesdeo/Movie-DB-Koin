package com.test.moviedbkoin.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.core.data.Resource
import com.test.core.extension.observeData
import com.test.domain.model.home.request.GeneralRequest
import com.test.moviedbkoin.databinding.ActivityDetailMovieBinding
import com.test.moviedbkoin.ui.home.HomeViewModel
import com.test.moviedbkoin.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityDetailMovieBinding::inflate)
    private val homeViewModel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        homeViewModel.getDetailMovie(GeneralRequest(movieID = intent.getIntExtra("id", 0)))
        initView()
        observable()
    }

    private fun observable() {
        observeData(homeViewModel.detailMovie) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {

                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
    }

    private fun initView() {

    }
}