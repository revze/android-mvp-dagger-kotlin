package id.revan.mvpwithdagger.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.revan.mvpwithdagger.R
import id.revan.mvpwithdagger.adapter.PostAdapter
import id.revan.mvpwithdagger.api.ApiInterface
import id.revan.mvpwithdagger.di.Injector
import id.revan.mvpwithdagger.extensions.gone
import id.revan.mvpwithdagger.extensions.visible
import id.revan.mvpwithdagger.helper.LayoutHelper
import id.revan.mvpwithdagger.model.Post
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var apiInterface: ApiInterface

    @Inject
    lateinit var layoutHelper: LayoutHelper

    private lateinit var postAdapter: PostAdapter
    private val posts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Injector.obtain().inject(this)

        postAdapter = PostAdapter(posts)
        rv_post.adapter = postAdapter
        rv_post.layoutManager = LinearLayoutManager(this)

        onAttachView()
        presenter.getPosts()
    }

    override fun onLoadPost() {
        layout_wrapper.visible()
        rv_post.gone()
        layoutHelper.showLoader(layout_wrapper)
    }

    override fun onSuccessLoadPost(posts: List<Post>) {
        layout_wrapper.gone()
        rv_post.visible()
        this.posts.clear()
        this.posts.addAll(posts)
        postAdapter.notifyDataSetChanged()
    }

    override fun onFailedLoadPost(message: String) {
        layout_wrapper.visible()
        rv_post.gone()
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
