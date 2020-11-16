package com.github.yangkangli.example;

import android.app.Application;

import com.github.yangkangli.x.log.XLog;
import com.github.yangkangli.x.log.adapter.ConsoleAdapter;
import com.github.yangkangli.x.log.adapter.DiskAdapter;
import com.github.yangkangli.x.log.core.BaseLogStrategy;
import com.github.yangkangli.x.log.core.ILogAdapter;
import com.github.yangkangli.x.log.strategy.DefaultLogStrategy;

import java.io.File;

public class LocalApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initXLog();
    }

    private void initXLog() {

        // 创建控制台日志适配器
        BaseLogStrategy consoleStrategy = new DefaultLogStrategy.Builder().setShowThreadName(true).build();
        ILogAdapter consoleAdapter = new ConsoleAdapter.Builder().setLoggable(BuildConfig.DEBUG).setLogStrategy(consoleStrategy).build();

        // 创建文件日志适配器
        BaseLogStrategy diskStrategy = new DefaultLogStrategy.Builder().setShowThreadName(true).build();
        File logsPath = getExternalFilesDir("Logs");
        ILogAdapter diskAdapter = new DiskAdapter.Builder().setLoggable(BuildConfig.DEBUG).setLogFilePath(logsPath)
                .setLogStrategy(diskStrategy).build();

        // 初始化
        XLog.init(consoleAdapter, diskAdapter);
    }
}
