package codenevisha.ir.app.journey.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.lang.reflect.ParameterizedType

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 16:08
 */
abstract class BaseActivity<V : BaseViewModel, B : ViewDataBinding>
    : AppCompatActivity(), BaseViewGroup<V, B> {

    final override lateinit var binding: B

    override lateinit var viewModelFactory: ViewModelProvider.Factory

    val backCallback: MutableLiveData<OnBackPressedListener?> = MutableLiveData()

    override val viewModel: V by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProviders.of(this, viewModelFactory).get((javaClass
                .genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<V>)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setLifecycleOwner(this)
    }

    override fun onBackPressed() {
        if (backCallback.value == null) {
            super.onBackPressed()
        } else {
            if (backCallback.value?.onBackPressed(this) == false) super.onBackPressed()
        }
    }

    override fun onDestroy() {
        if(backCallback.value != null){
            backCallback.value = null
        }
        super.onDestroy()
    }

}