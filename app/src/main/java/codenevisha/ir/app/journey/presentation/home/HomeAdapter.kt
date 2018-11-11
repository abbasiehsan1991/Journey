package codenevisha.ir.app.journey.presentation.home

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import codenevisha.ir.app.journey.R
import codenevisha.ir.app.journey.data.model.Article
import codenevisha.ir.app.journey.databinding.RecyclerMainfragmentItemBinding

/**
 * CREATED BY Javadroid FOR `Journey` PROJECT
 * AT: 2018/Nov/11 14:48
 */

class HomeAdapter(
        private var mainList: ArrayList<Article>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun swapData(dataList: ArrayList<Article>) {
        if (mainList !== dataList) {
            mainList = dataList
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = DataBindingUtil.inflate<RecyclerMainfragmentItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recycler_mainfragment_item, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(rawHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = rawHolder as ItemViewHolder
        holder.onBind(mainList[position])
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

}

class ItemViewHolder(private val mBinding: RecyclerMainfragmentItemBinding)
    : RecyclerView.ViewHolder(mBinding.root) {


    fun onBind(article: Article) {

        mBinding.article = article

    }
}