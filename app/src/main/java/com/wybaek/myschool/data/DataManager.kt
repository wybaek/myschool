package com.wybaek.myschool.data

import javax.inject.Inject
import javax.inject.Singleton

import rx.Observable
import com.wybaek.myschool.data.local.DatabaseHelper
import com.wybaek.myschool.data.model.Ribot
import com.wybaek.myschool.data.remote.RibotsService

@Singleton
class DataManager @Inject constructor(private val ribotsService: RibotsService,
                                      private val databaseHelper: DatabaseHelper) {

    fun syncRibots(): Observable<Ribot> {
        return ribotsService.getRibots()
                .concatMap { databaseHelper.setRibots(it) }
    }

    fun getRibots(): Observable<List<Ribot>> {
        return databaseHelper.getRibots().distinct()
    }
}
