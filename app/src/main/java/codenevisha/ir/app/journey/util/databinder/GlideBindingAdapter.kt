package codenevisha.ir.app.journey.util.databinder

import android.databinding.BindingAdapter
import android.util.Log
import android.widget.ImageView
import codenevisha.ir.app.journey.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class GlideBindingAdapter {

    companion object {
        private val TAG = "GlideBindingAdapter"

        @JvmStatic
        @BindingAdapter("app:imageFromlocal")
        fun setImageResource(view: ImageView, imageUrl: Int?) {

            val context = view.context

            val options = RequestOptions()
                    .error(R.drawable.ic_error_black_24dp)

            imageUrl?.let {

            Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(imageUrl)
                    .into(view)
            }
        }

        @JvmStatic
        @BindingAdapter("app:imageFromUrl")
        fun setImageResource(view: ImageView, imageUrl: String?) {

            val context = view.context

            Log.d(TAG, "setMainImageResource: $imageUrl")
            val options = RequestOptions()
                    .error(R.drawable.ic_error_black_24dp)
                    .placeholder(R.drawable.ic_cloud_download_black_24dp)

            imageUrl?.let {

                Glide.with(context)
                        .setDefaultRequestOptions(options)
                        .load(imageUrl)
                        .into(view)
            }
        }

    }
}
