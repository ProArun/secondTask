package com.arun.icclimbsystem.models

data class Lec(
    val duration: String,
    val period_id: Int,
    val period_type: String,
    val subject_code: String,
    val subject_name: String,
    val subject_type: String,
    val teacher_id: String,
    val teacher_name: String,
    val timing: String
)