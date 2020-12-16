package com.arun.icclimbsystem.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arun.icclimbsystem.data.MainRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: MainRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ShowViewModel::class.java) -> ShowViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}