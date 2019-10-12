package id.revan.mvpwithdagger.ui.main

import id.revan.mvpwithdagger.api.ApiInterface
import id.revan.mvpwithdagger.model.Post
import id.revan.mvpwithdagger.ui.base.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter @Inject constructor(private val apiInterface: ApiInterface) :
    Presenter<MainView> {

    private var view: MainView? = null

    override fun onAttach(view: MainView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun getPosts() {
        view?.onLoadPost()

        apiInterface.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                view?.onFailedLoadPost("Failed to load post")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                view?.onSuccessLoadPost(response.body()!!)
            }

        })
    }
}