package com.arun.icclimbsystem.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arun.icclimbsystem.databinding.FragmentShowBinding
import com.arun.icclimbsystem.other.Constants.TAG
import com.arun.icclimbsystem.viewModel.ShowViewModel
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import java.util.*


class ShowFragment : BaseFragment<ShowViewModel, FragmentShowBinding>() {

    private val listOfDayOfWeek = listOf(
        "Sun",
        "Mon",
        "Tue",
        "Wed",
        "Thu",
        "Fri",
        "Sat"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarView.setCalendarListener(object : CollapsibleCalendar.CalendarListener {
            override fun onClickListener() {

            }

            override fun onDataUpdate() {

            }

            override fun onDayChanged() {

            }

            override fun onDaySelect() {
                val day = binding.calendarView.selectedDay

                if (day != null) {
                    val cal = Calendar.getInstance()
                    cal.set(day.year, day.month, day.day)
                    val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)

                    Log.d(
                        TAG,
                        "onDaySelect: " + day.year + "/" + day.month + "/" + day.day + "/" + listOfDayOfWeek[dayOfWeek - 1]
                    )
                    viewModel.getNotes()
                }
            }

            override fun onItemClick(v: View) {

            }

            override fun onMonthChange() {

            }

            override fun onWeekChange(position: Int) {

            }

        })

    }


    override fun getViewModelClass() = ShowViewModel::class.java

    override fun getFragmentLayoutBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentShowBinding.inflate(inflater, container, false)


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_show, container, false)
//    }
}