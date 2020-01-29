package com.wybaek.myschool.ui.base

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
interface Presenter<in V : MvpView> {
    fun attachView(view: V)
    fun detachView()
}
