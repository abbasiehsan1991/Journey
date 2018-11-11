package codenevisha.ir.app.journey.util;

import android.util.Log;

/**
 * Created by barmar on 7/4/2017.
 */

public class Logger {

    private static String defaultTag = "WiCalory";
    private static boolean logDisabled = false;

    public static final int LOG_V = 1;
    public static final int LOG_D = 2;
    public static final int LOG_I = 3;
    public static final int LOG_W = 4;
    public static final int LOG_E = 5;
    public static final int LOG_F = 6;

    public static void appLog(String message){
        appLog(message , LOG_V);
    }

    public static void appLog(String message, int type){
        pringlog(message , type, false);
    }

    public static void printLog(String message) {
        printLog(message , LOG_V);
    }

    public static void printLog(String message, int type) {
        pringlog(message , type, true);
    }

    private static void pringlog(String message, int type, boolean isFortest){
        if (logDisabled && isFortest) return;
        printLog(defaultTag , message , type);
    }

    private static void printLog(String tag, String message, int type ) {
        if (message != null && tag!=null ) {
            switch (type) {
                case LOG_V:
                    Log.v(tag, message);
                    break;
                case LOG_D:
                    Log.d(tag, message);
                    break;
                case LOG_I:
                    Log.i(tag, message);
                    break;
                case LOG_W:
                    Log.w(tag, message);
                    break;
                case LOG_E:
                    Log.e(tag, message);
                    break;
                case LOG_F:
                    Log.wtf(tag, message);
                    break;
                default:
                    break;
            }
        }
    }
}
