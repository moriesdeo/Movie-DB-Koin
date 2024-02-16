package com.test.moviedbkoin.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.core.data.Resource
import com.test.core.extension.data
import com.test.core.extension.observeData
import com.test.moviedbkoin.databinding.ActivityMainBinding
import com.test.moviedbkoin.ui.home.adapter.GenreAdapter
import com.test.moviedbkoin.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val homeViewModel: HomeViewModel by viewModel()
    private val genreAdapter: GenreAdapter by lazy {
        GenreAdapter {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        observable()
    }

    private fun initView() {
        binding.apply {
            genreRv.adapter = genreAdapter
        }
    }

    private fun observable() {
        observeData(homeViewModel.genreMovie) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        genreAdapter?.submitList(result.data()?.genres.orEmpty())
                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
    }
}