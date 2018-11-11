package codenevisha.ir.app.journey.app

import android.app.Application
import android.content.Context
import codenevisha.ir.app.journey.util.helper.LocaleHelper


class JourneyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "fa"))
    }
}
