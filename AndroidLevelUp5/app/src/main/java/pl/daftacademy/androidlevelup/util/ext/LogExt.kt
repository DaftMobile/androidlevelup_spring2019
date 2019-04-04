package pl.daftacademy.androidlevelup.util.ext

import android.util.Log

fun Any.loge(tag: String, format: (String) -> String = { it }) = Log.e(tag, format.invoke(toString()))

fun Any.logw(tag: String, format: (String) -> String = { it }) = Log.w(tag, format.invoke(toString()))

fun Any.logi(tag: String, format: (String) -> String = { it }) = Log.i(tag, format.invoke(toString()))

fun Any.logd(tag: String, format: (String) -> String = { it }) = Log.d(tag, format.invoke(toString()))

fun Any.logv(tag: String, format: (String) -> String = { it }) = Log.v(tag, format.invoke(toString()))