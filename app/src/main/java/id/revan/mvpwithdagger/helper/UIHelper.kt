package id.revan.mvpwithdagger.helper

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class UIHelper @Inject constructor() : AnkoLogger {
    fun showAlert() {
        info("show alert")
    }
}