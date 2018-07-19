package com.wyman.library_common.utils;

import android.util.Log;

/**
 * Log统一管理类
 * 
 * @author wy
 * 
 */
public class LogUtils
{

	private LogUtils()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static boolean isDebug = true ;// 是否需要打印bug，可以在application的onCreate函数里面初始化
	private static final String TAG = "Wyman";

	// 下面四个是默认tag的函数
	public static void i(String msg)
	{
		if (isDebug)
			Log.i(TAG, msg);
	}

	public static void d(String msg)
	{
		if (isDebug)
			Log.d(TAG, msg);
	}

	public static void e(String msg)
	{
		if (isDebug)
			Log.e(TAG, msg);
	}

	public static void v(String msg)
	{
		if (isDebug)
			Log.v(TAG, msg);
	}

	// 下面是传入自定义tag的函数
	public static void i(String tag, String msg)
	{
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg)
	{
		if (isDebug)
			Log.d(tag, msg);
	}

	public static void e(String tag, String msg)
	{
		if (isDebug) {
			if (msg.length() > 3000) {//信息量大，分段打印
				for (int i = 0; i < msg.length(); i += 3000) {
					if (i + 3000 < msg.length()) {

						Log.e(tag + i, msg.substring(i, i + 3000));
					} else {
						Log.e(tag + i, msg.substring(i, msg.length()));
					}
				}
			} else {

				Log.e(tag, msg);
			}
		}
	}

	public static void v(String tag, String msg)
	{
		if (isDebug)
			Log.v(tag, msg);
	}
}