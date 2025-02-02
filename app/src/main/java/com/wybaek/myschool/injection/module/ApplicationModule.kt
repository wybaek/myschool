package com.wybaek.myschool.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.wybaek.myschool.injection.ApplicationContext
import javax.inject.Singleton

/**
 * Provide application-level dependencies.
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }
}
