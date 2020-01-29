package com.wybaek.myschool.data.remote

import com.wybaek.myschool.data.model.*
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface SchoolService {
    @GET("/api/user/searchSchoolList.jsp")
    fun findSchool(@Query("atptOfcdcScCode") atptOfcdcScCode : String,
                   @Query("kraOrgNm") kraOrgNm : String) : Observable<SearchResult>

    @GET("/api/user/schoolInfo2.jsp")
    fun findClassroom(@Query("atptOfcdcScCode") atptOfcdcScCode : String,
                  @Query("schulCrseScCode") schulCrseScCode : String,
                  @Query("schulCode") schulCode : String) : Observable<ClassResult>

    @GET("/api/user/foodMonth.jsp")
    fun findFood(@Query("atptOfcdcScCode") atptOfcdcScCode : String,
                 @Query("schulCode") schulCode : String,
                 @Query("ay") ay : String) : Observable<FoodResult>

    @GET("/api/user/haksaMonth.jsp")
    fun findSchedule(@Query("atptOfcdcScCode") atptOfcdcScCode : String,
                 @Query("schulCrseScCode") schulCrseScCode : String,
                 @Query("schulCode") schulCode : String,
                 @Query("ay") ay : String,
                 @Query("mm") mm : String) : Observable<ScheduleResult>

    @GET("/api/user/classroomInfo.jsp")
    fun findTimetable(@Query("atptOfcdcScCode") atptOfcdcScCode : String,
                 @Query("schulCrseScCode") schulCrseScCode : String,
                 @Query("schulCode") schulCode : String,
                 @Query("grade") grade : String,
                 @Query("classCode") classCode : String) : Observable<TimeTableResult>

    @GET("/api/user/schoolInfo.jsp")
    fun getSchool(@Query("atptOfcdcScCode") atptOfcdcScCode : String,
                  @Query("schulCrseScCode") schulCrseScCode : String,
                  @Query("schulCode") schulCode : String) : Observable<SchoolResult>
}