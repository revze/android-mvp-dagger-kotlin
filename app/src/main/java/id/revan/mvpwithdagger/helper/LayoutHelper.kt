package id.revan.mvpwithdagger.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import id.revan.mvpwithdagger.R
import kotlinx.android.synthetic.main.layout_error.view.*

class LayoutHelper(private val context: Context) {
    fun showLoader(viewGroup: ViewGroup) {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_loader, null, false)
        viewGroup.removeAllViews()
        viewGroup.addView(view)
    }

    fun showLayoutError(viewGroup: ViewGroup, message: String) {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_error, null, false)
        val tvError = view.tv_error
        tvError.text = message

        viewGroup.removeAllViews()
        viewGroup.addView(view)
    }
}