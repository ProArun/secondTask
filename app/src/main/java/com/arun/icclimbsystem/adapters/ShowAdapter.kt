package com.arun.icclimbsystem.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.arun.icclimbsystem.R
import com.arun.icclimbsystem.models.Lec
import kotlinx.android.synthetic.main.item_note.view.*

class ShowAdapter(private val notesList: ArrayList<Lec>) :
    RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        return ShowViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )

    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.itemView.tvTime.text = notesList.get(position).timing
        holder.itemView.tvSubCode.text = notesList.get(position).subject_code
        holder.itemView.tvSubName.text = notesList.get(position).subject_name
        holder.itemView.tvFacultyName.text = notesList.get(position).teacher_name ?: ""
        holder.itemView.tvPeriodType.text = notesList.get(position).period_type
        holder.itemView.tvSubType.text = notesList.get(position).subject_type
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}