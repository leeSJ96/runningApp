package com.example.running.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.running.db.Run
import com.example.running.repositories.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
) : ViewModel(){


    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }

}