package com.xcheng.okhttp.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.Executor;

public class Platform implements Executor {
    private static final Platform PLATFORM = new Platform();
    private final Handler handler = new Handler(Looper.getMainLooper());

    private Platform() {
        Log.e(Platform.class.getSimpleName(), "create Platform");
    }

    /**
     * 保证在Handler消息队列中按顺序执行
     */
    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }

    public static Platform get() {
        return PLATFORM;
    }

    /**
     * Returns {@code true} if called on the main thread, {@code false} otherwise.
     */
    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
