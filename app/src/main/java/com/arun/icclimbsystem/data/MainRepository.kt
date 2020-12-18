package com.arun.icclimbsystem.data

import android.util.Log
import android.widget.Toast
import com.arun.icclimbsystem.models.ClassNotes
import com.arun.icclimbsystem.models.Weekday
import com.arun.icclimbsystem.other.Constants.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(
    private val api: NoteApi
) {
    var weeklyNotes: ArrayList<Weekday>? = null
    fun getNotes() {//: List<Weekday>?
        api.getNotes()
            .enqueue(object : Callback<ClassNotes> {
                override fun onResponse(call: Call<ClassNotes>, response: Response<ClassNotes>) {
                    if (response.isSuccessful) {
                        weeklyNotes = response.body()?.weekdays as ArrayList<Weekday>

                        Log.d(TAG, "onResponse: success")
                    } else {
                        Log.d(TAG, "onResponse: api error")
                    }
                }

                override fun onFailure(call: Call<ClassNotes>, t: Throwable) {
                    Log.d(TAG, "onFailure: network error")
                }

            })
        //return weeklyNotes
    }

}


