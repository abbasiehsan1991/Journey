package codenevisha.ir.app.journey.data.local.pref

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/11 10:14
 */
class UserPreference(val name: String) : DefaultPreference(name) {

    companion object {
        //PREF NAME
        const val PREF_NAME = "user_pref"

        //KEYS
        const val KEY_PHONE_NUMBER = "USER_NUMBER"
        const val KEY_GMAIL = "GMAIL"
        const val KEY_DEVICE_UUID = "DEVICE_UUID"
        const val KEY_TOKEN = "TOKEN"
        const val KEY_BIRTHDATE = "BIRTHDATE"
        const val KEY_GENDER = "GENDER"
        const val KEY_LAST_STATE = "LAST_STATE"


        //DEFAULTS
        const val DEFAULT_PHONE_NUMBER = ""
        const val DEFAUL_GMAIL = ""
        const val DEFAULT_DEVICE_UUID = ""
        const val DEFAULT_TOKEN = ""
        const val DEFAULT_BIRTHDATE = ""
        const val DEFAULT_GENDER = ""
        const val DEFAULT_LAST_STATE = 0

    }

}