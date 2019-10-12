package id.revan.mvpwithdagger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.revan.mvpwithdagger.R
import id.revan.mvpwithdagger.model.Post
import id.revan.mvpwithdagger.ui.postdetail.PostDetailActivity
import kotlinx.android.synthetic.main.item_row_post.view.*
import org.jetbrains.anko.startActivity

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.tv_title
        private val tvBody = itemView.tv_body
        private val context = itemView.context

        fun bind(post: Post) {
            tvTitle.text = post.title
            tvBody.text = post.body
            itemView.rootView.setOnClickListener {
                context.startActivity<PostDetailActivity>(PostDetailActivity.ID to post.id)
            }
        }
    }
}