package com.example.running.ui.frgment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.running.R
import com.example.running.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run){

    private val viewModel: MainViewModel by viewModels()
}