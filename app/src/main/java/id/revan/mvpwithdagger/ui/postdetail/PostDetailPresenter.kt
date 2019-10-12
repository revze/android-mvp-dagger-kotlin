package id.revan.mvpwithdagger.ui.postdetail

import id.revan.mvpwithdagger.api.ApiInterface
import id.revan.mvpwithdagger.model.Post
import id.revan.mvpwithdagger.ui.base.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PostDetailPresenter @Inject constructor(
    private val apiInterface: ApiInterface
) :
    Presenter<PostDetailView> {

    private var view: PostDetailView? = null

    override fun onAttach(view: PostDetailView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun getPost(id: String) {
        view?.onLoadPost()

        apiInterface.getPost(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                view?.onSuccessLoadPost(response.body()!!)
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                view?.onFailedLoadPost("Failed to load post")
            }
        })
    }
}