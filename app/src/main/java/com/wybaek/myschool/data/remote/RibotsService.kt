package com.wybaek.myschool.data.remote

import retrofit2.http.GET
import rx.Observable
import com.wybaek.myschool.data.model.Ribot

interface RibotsService {
    @GET("ribots")
    fun getRibots(): Observable<List<Ribot>>
}
