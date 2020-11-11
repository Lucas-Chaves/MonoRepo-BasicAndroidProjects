package br.com.lucas.motivation.infra

import android.content.Context

class SecurityPreferences(context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        mSharedPreferences.edit().putString(key,value).apply()
    }

    fun getString(key: String) : String {
        return  mSharedPreferences.getString(key, "") ?: ""
    }

}

//android
//val shared = this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
//shared.edit().putString("name","value").apply()
//AndroidX
//shared.edit(commit = true) { putBoolean("key", true) }
