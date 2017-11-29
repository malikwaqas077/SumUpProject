package com.example.waqas.studentdsapp;

/**
 * Created by waqas on 11/29/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    static SharedPreferences pref;
    Editor editor;

    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "MyLoginPref";
    // Pref Index name
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USERYYPE = "type";
    private static final String KEY_USERID = "campus_id";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
//        editor.putString(KEY_USERYYPE,type);
//        editor.putString(KEY_USERID,CustomerId);
        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }
    public String getKeyUserType(){
        return pref.getString(KEY_USERYYPE,"");
    }
    public  String getKeyUserId(){
        return pref.getString(KEY_USERID,"");
    }
}