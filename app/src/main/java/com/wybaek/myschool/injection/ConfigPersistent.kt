package com.wybaek.myschool.injection

import com.wybaek.myschool.injection.component.ConfigPersistentComponent
import javax.inject.Scope

/**
 * A scoping annotation to permit dependencies conform to the life of the
 * [ConfigPersistentComponent]
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ConfigPersistent
