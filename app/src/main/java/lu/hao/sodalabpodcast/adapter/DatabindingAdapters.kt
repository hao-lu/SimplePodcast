package lu.hao.sodalabpodcast

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.drawable.ic_launcher_background)
        .into(view)
}