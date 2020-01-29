package com.wybaek.myschool

import android.app.Application
import android.support.annotation.VisibleForTesting
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import com.wybaek.myschool.injection.component.ApplicationComponent
import com.wybaek.myschool.injection.component.DaggerApplicationComponent
import com.wybaek.myschool.injection.module.ApplicationModule

open class BoilerplateApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this))
            return
        LeakCanary.install(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initDaggerComponent()
    }

    @VisibleForTesting
    fun initDaggerComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}