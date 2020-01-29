package com.wybaek.myschool.ui.main

import com.wybaek.myschool.data.model.Ribot
import com.wybaek.myschool.ui.base.BasePresenter
import com.wybaek.myschool.ui.base.MvpView

object MainContract {

    interface View: MvpView {
        fun showRibots(ribots: List<Ribot>)
        fun showRibotsEmpty()
        fun showError()
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun loadRibots()
    }
}
