package com.test.moviedbkoin.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.moviedbkoin.databinding.ActivityMainBinding
import com.test.moviedbkoin.ui.utils.delegate.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}