package com.arun.icclimbsystem.models

data class ClassNotes(
    val clas: Int,
    val day: String,
    val error: String,
    val section: String,
    val semester: String,
    val stream_id: String,
    val uptimetable: List<Any>,
    val weekdays: List<Weekday>
)