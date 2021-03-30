package com.example.running.ui.frgment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.running.R
import com.example.running.ui.MainViewModel
import com.example.running.ui.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics){
    private val viewModel: StatisticsViewModel by viewModels()
}