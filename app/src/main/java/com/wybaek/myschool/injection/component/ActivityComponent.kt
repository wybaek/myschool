package com.wybaek.myschool.injection.component

import dagger.Subcomponent
import com.wybaek.myschool.injection.PerActivity
import com.wybaek.myschool.injection.module.ActivityModule
import com.wybaek.myschool.ui.main.MainActivity

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}
