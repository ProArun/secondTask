package com.arun.icclimbsystem.viewModel

import androidx.lifecycle.ViewModel
import com.arun.icclimbsystem.data.MainRepository
import com.arun.icclimbsystem.models.Lec
import com.arun.icclimbsystem.models.Weekday

class ShowViewModel(
    private val repository: MainRepository
) : ViewModel() {
    private val numbersMap = mapOf(1 to 6, 2 to 0, 3 to 1, 4 to 2, 5 to 3, 6 to 4, 7 to 5)
    var weeklyNotes: ArrayList<Weekday>? = null
    private var weekday: Weekday? = null

    init {
        repository.getNotes()
    }

    fun getNotes(dayOfWeek: Int): List<Lec>? {
        weeklyNotes = repository.weeklyNotes
        val day = numbersMap[dayOfWeek] ?: error("")

        weekday = weeklyNotes?.get(day)
        //Log.d(TAG, "getNotes: $weekday")
        return weekday?.lec
    }
}