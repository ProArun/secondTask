package com.arun.icclimbsystem.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.icclimbsystem.data.MainRepository
import com.arun.icclimbsystem.models.Weekday
import com.arun.icclimbsystem.other.Constants.TAG
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class ShowViewModel(
    private val repository: MainRepository
) : ViewModel() {

    var weeklyNotes: ArrayList<Weekday>? = null

    init {
        repository.getNotes()
    }

    fun getNotes() {
        weeklyNotes = repository.weeklyNotes
        //weeklyNotes = repository.getNotes()
        val lec = weeklyNotes!![1]//.lec[1]
        val result = lec
        Log.d(TAG, "getNotes: $result")
        //Log.d(TAG, "getNotes: viewModel is working")
    }



}