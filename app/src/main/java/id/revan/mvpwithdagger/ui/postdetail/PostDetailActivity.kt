package id.revan.mvpwithdagger.ui.postdetail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import id.revan.mvpwithdagger.R
import id.revan.mvpwithdagger.api.ApiInterface
import id.revan.mvpwithdagger.di.Injector
import id.revan.mvpwithdagger.extensions.gone
import id.revan.mvpwithdagger.extensions.visible
import id.revan.mvpwithdagger.helper.LayoutHelper
import id.revan.mvpwithdagger.model.Post
import kotlinx.android.synthetic.main.activity_post_detail.*
import javax.inject.Inject

class PostDetailActivity : AppCompatActivity(), PostDetailView {

    @Inject
    lateinit var presenter: PostDetailPresenter

    @Inject
    lateinit var apiInterface: ApiInterface

    @Inject
    lateinit var layoutHelper: LayoutHelper

    companion object {
        const val ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val id = intent.getStringExtra(ID) ?: ""

        Injector.obtain().inject(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onAttachView()
        presenter.getPost(id)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onLoadPost() {
        layout_wrapper.visible()
        sv_post_detail.gone()
        layoutHelper.showLoader(layout_wrapper)
    }

    override fun onSuccessLoadPost(post: Post) {
        layout_wrapper.gone()
        sv_post_detail.visible()
        tv_title.text = post.title
        tv_body.text = post.body
    }

    override fun onFailedLoadPost(message: String) {
        layout_wrapper.visible()
        sv_post_detail.gone()
        layoutHelper.showLayoutError(layout_wrapper, message)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }
}
