package com.test.moviedbkoin.ui.movie

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.core.data.Resource
import com.test.core.extension.data
import com.test.core.extension.loadImage
import com.test.core.extension.observeData
import com.test.core.extension.toast
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.home.request.GeneralRequest
import com.test.domain.model.movie.DetailMovieData
import com.test.domain.model.movie.ReviewData
import com.test.moviedbkoin.BuildConfig
import com.test.moviedbkoin.databinding.ActivityDetailMovieBinding
import com.test.moviedbkoin.ui.home.HomeViewModel
import com.test.moviedbkoin.ui.movie.adapter.ProductionCompanyAdapter
import com.test.moviedbkoin.ui.movie.adapter.ProductionCountriesAdapter
import com.test.moviedbkoin.ui.movie.adapter.ReviewsAdapter
import com.test.moviedbkoin.ui.movie.adapter.SpokenLanguageAdapter
import com.test.moviedbkoin.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityDetailMovieBinding::inflate)
    private val homeViewModel: HomeViewModel by viewModel()
    private val spokenLanguageAdapter by lazy {
        SpokenLanguageAdapter()
    }
    private val productionCountriesAdapter by lazy {
        ProductionCountriesAdapter()
    }
    private val productionCompanyAdapter by lazy {
        ProductionCompanyAdapter()
    }
    private val reviewsAdapter by lazy {
        ReviewsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        homeViewModel.getDetailMovie(GeneralRequest(movieID = intent.getIntExtra("id", 0)))
        homeViewModel.getReviews(GeneralRequest(page = 1, movieID = intent.getIntExtra("id", 0)))
        initView()
        observable()
    }

    private fun observable() {
        observeData(homeViewModel.reviews) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        setReviews(result.data())
                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
        observeData(homeViewModel.detailMovie) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        setUI(result.data())
                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
        observeData(homeViewModel.videos) { result ->
            result?.let {
                when (it) {
                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        try {
                            startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.youtube.com/watch?v=${result.data()?.results?.first()?.key}")
                                )
                            )
                        } catch (e: ActivityNotFoundException) {
                            toast("Alamat url tidak ditemukan")
                        }
                    }
                }
            }
        }
    }

    private fun setReviews(data: BaseResponseData<List<ReviewData>>?) {
        binding.apply {
            reviewsAdapter.submitList(data?.results)
        }
    }

    private fun initView() {
        binding.apply {
            spokenLanguageRv.adapter = spokenLanguageAdapter
            productionCompaniesRv.adapter = productionCompanyAdapter
            productionCountriesRv.adapter = productionCountriesAdapter
            reviewRv.adapter = reviewsAdapter
        }
    }

    private fun setUI(data: DetailMovieData?) {
        binding.apply {
            overviewTv.text = "Overview :" + data?.overview
            titleTv.text = "Title " + data?.title
            imageIv.loadImage(BuildConfig.LOAD_IMAGE + data?.backdrop_path)
            originalLanguageTv.text = "Original Language :" + data?.original_language
            popularityTv.text = "Popularity :" + data?.popularity.toString()
            voteAverageTv.text = "Vote Average :" + data?.vote_average.toString()
            voteCount.text = "Vote Count :" + data?.vote_count.toString()
            productionCompanyAdapter.submitList(data?.production_companies)
            productionCountriesAdapter.submitList(data?.production_countries)
            spokenLanguageAdapter.submitList(data?.spoken_languages)
            openYoutubeIv.setOnClickListener {
                homeViewModel.getVideos(GeneralRequest(movieID = data?.id))
            }
        }
    }
}