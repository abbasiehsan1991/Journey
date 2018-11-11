package codenevisha.ir.app.journey.presentation.base

import android.support.design.widget.AppBarLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 14:39

 */
interface ToolbarManager {
    val toolbar: Toolbar?
    var toolbarTitle: String
        get() = toolbar?.title.toString()
        set(value) {
            toolbar?.title = value
        }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val appBar = toolbar?.parent
                val scrollItem = if (appBar != null && appBar is AppBarLayout) appBar else toolbar

            }
        })
    }

    fun attatchMenu(menuId: Int) {
        if (menuId == 0) {
            return
        }
        toolbar?.inflateMenu(menuId)
    }

    fun changeMenuItemVisibility(menuId: Int, visibility: Boolean) {
        toolbar?.menu?.findItem(menuId)?.isVisible = visibility
    }

    fun registerOnMenuClickListener(callback: (menuItem: MenuItem) -> Boolean) {
        toolbar?.setOnMenuItemClickListener {
            callback(it)
        }
    }

}