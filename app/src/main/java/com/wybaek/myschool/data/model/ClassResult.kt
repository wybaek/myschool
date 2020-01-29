package com.wybaek.myschool.data.model

data class ClassResult(val applicationData: ClassApplicationData)

data class ClassApplicationData(val selectHakgyoInfoClassCnt: Collection<Classroom>)

data class Classroom(val grade: Int, val cnt: Int)