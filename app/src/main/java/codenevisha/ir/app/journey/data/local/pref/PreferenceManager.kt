package codenevisha.ir.app.journey.data.local.pref

import android.content.Context
import codenevisha.ir.app.journey.util.helper.SingletonHolder

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/09 18:23
 */
class PreferenceManager private constructor(private val context: Context) {

    init {
        // Init using context argument
    }

    companion object : SingletonHolder<PreferenceManager, Context>(::PreferenceManager) {}

    val userPreference: DefaultPreference by lazy {
        val preference = UserPreference(UserPreference.PREF_NAME)
        preference.create(context)
        preference
    }


}


