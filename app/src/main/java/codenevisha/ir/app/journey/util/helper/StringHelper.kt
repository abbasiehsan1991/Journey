package com.yaramobile.wicalory.util.helper

import android.text.TextUtils

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jul/23 16:07
 */
class StringHelper {

    companion object {

        fun convertEnglishNumbers(input: String): String {
            return input.replace('0', '۰')
                    .replace('1', '۱')
                    .replace('2', '۲')
                    .replace('3', '۳')
                    .replace('4', '۴')
                    .replace('5', '۵')
                    .replace('6', '۶')
                    .replace('7', '۷')
                    .replace('8', '۸')
                    .replace('9', '۹')
        }

        fun convertPersianNumbers(input: String): String {
            return input.replace('۰', '0')
                    .replace('۱', '1')
                    .replace('۲', '2')
                    .replace('۳', '3')
                    .replace('۴', '4')
                    .replace('۵', '5')
                    .replace('۶', '6')
                    .replace('۷', '7')
                    .replace('۸', '8')
                    .replace('۹', '9')
        }


        fun isEmpty(value: String): Boolean = TextUtils.isEmpty(value)

    }

}