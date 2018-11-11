package codenevisha.ir.app.journey.util.databinder

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import codenevisha.ir.app.journey.data.model.Article
import codenevisha.ir.app.journey.presentation.home.HomeAdapter
import java.util.*

class BindingList {

    companion object {

        @JvmStatic
        @BindingAdapter("app:setup_adapter")
        fun setItems(recyclerView: RecyclerView, items: ArrayList<Article>?) {

            val adapter = recyclerView.adapter as HomeAdapter?

            if (adapter != null && items != null) {
                adapter.swapData(items)
            }
        }
    }
}
