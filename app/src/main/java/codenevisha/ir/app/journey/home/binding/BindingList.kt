package codenevisha.ir.app.journey.home.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import codenevisha.ir.app.journey.data.pojo.Article
import codenevisha.ir.app.journey.home.AdapterHome
import java.util.*

class BindingList {

    companion object {

        @JvmStatic
        @BindingAdapter("app:setup_adapter")
        fun setItems(recyclerView: RecyclerView, items: ArrayList<Article>?) {

            val adapter = recyclerView.adapter as AdapterHome?

            if (adapter != null && items != null) {
                adapter.swapData(items)
            }
        }
    }
}
