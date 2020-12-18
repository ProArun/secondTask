package com.arun.icclimbsystem.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arun.icclimbsystem.adapters.ShowAdapter
import com.arun.icclimbsystem.databinding.FragmentShowBinding
import com.arun.icclimbsystem.models.Lec
import com.arun.icclimbsystem.other.Constants.TAG
import com.arun.icclimbsystem.viewModel.ShowViewModel
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import java.util.*
import kotlin.collections.ArrayList


class ShowFragment : BaseFragment<ShowViewModel, FragmentShowBinding>() {

    var lec: List<Lec>? = null
    var dayOfWeek: Int? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var showAdapter: ShowAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cal = Calendar.getInstance()
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
        if (lec == null) {
            lec = viewModel.getNotes(dayOfWeek as Int)
            binding.progressBar.visibility = View.VISIBLE
        } else {
            //setup recycler view
            binding.progressBar.visibility = View.INVISIBLE
            showAdapter = ShowAdapter(lec as ArrayList<Lec>)
            recyclerView = binding.rvNotes
            recyclerView.adapter = showAdapter
            showAdapter.notifyDataSetChanged()
        }


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
                    //val cal = Calendar.getInstance()
                    cal.set(day.year, day.month, day.day)
                    dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
                    lec = viewModel.getNotes(dayOfWeek as Int)
                    if (lec == null) {
                        binding.progressBar.visibility = View.VISIBLE
                    } else {
                        //setup recycler view
                        binding.progressBar.visibility = View.INVISIBLE
                        showAdapter = ShowAdapter(lec as ArrayList<Lec>)
                        recyclerView = binding.rvNotes
                        recyclerView.adapter = showAdapter
                        showAdapter.notifyDataSetChanged()
                    }
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

    override fun onStart() {
        super.onStart()
    }

    override fun getViewModelClass() = ShowViewModel::class.java

    override fun getFragmentLayoutBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentShowBinding.inflate(inflater, container, false)

}