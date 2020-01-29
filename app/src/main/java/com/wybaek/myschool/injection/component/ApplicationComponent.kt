package com.wybaek.myschool.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import com.wybaek.myschool.data.DataManager
import com.wybaek.myschool.data.SyncService
import com.wybaek.myschool.data.local.DatabaseHelper
import com.wybaek.myschool.data.remote.RibotsService
import com.wybaek.myschool.data.remote.SchoolService
import com.wybaek.myschool.injection.ApplicationContext
import com.wybaek.myschool.injection.module.ApplicationModule
import com.wybaek.myschool.injection.module.DataModule

import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class))
interface ApplicationComponent {
    fun inject(syncService: SyncService)

    @ApplicationContext fun context(): Context
    fun application(): Application
    fun ribotsService(): RibotsService
    // 추가
    fun schoolService(): SchoolService
    fun databaseHelper(): DatabaseHelper
    fun dataManager(): DataManager
}
