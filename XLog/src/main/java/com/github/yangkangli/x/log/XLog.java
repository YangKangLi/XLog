package com.github.yangkangli.x.log;

import android.content.Context;

import com.github.yangkangli.x.log.adapter.ConsoleAdapter;
import com.github.yangkangli.x.log.adapter.DiskAdapter;
import com.github.yangkangli.x.log.core.BaseLogStrategy;
import com.github.yangkangli.x.log.core.ILogAdapter;
import com.github.yangkangli.x.log.core.LogCore;
import com.github.yangkangli.x.log.strategy.DefaultLogStrategy;

import java.io.File;

public class XLog {
    private LogCore logger;


    /**
     * 单例对象持有类
     */
    private static class Holder {
        private static final XLog INSTANCE = new XLog();
    }


    /**
     * 得到单例对象
     *
     * @return
     */
    private static XLog getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 私有构造方法
     */
    private XLog() {
        logger = new LogCore();
    }

    /******************************************************************************************************************
     * 对外提供的接口
     ******************************************************************************************************************/


    /**
     * 初始化
     *
     * @param logAdapters
     */
    public static void init(ILogAdapter... logAdapters) {
        XLog.addLogAdapter(logAdapters);
    }

    /**
     * 增加日志适配器
     *
     * @param logAdapters
     */
    private static void addLogAdapter(ILogAdapter... logAdapters) {
        if (logAdapters != null && logAdapters.length > 0) {
            for (ILogAdapter adapter : logAdapters) {
                getInstance().logger.addAdapter(adapter);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void v(Object message) {
        getInstance().logger.v(null, message, null);
    }

    public static void v(String subTag, Object message) {
        getInstance().logger.v(subTag, message, null);
    }

    public static void v(Throwable throwable) {
        getInstance().logger.v(null, null, throwable);
    }

    public static void v(String subTag, Throwable throwable) {
        getInstance().logger.v(subTag, null, throwable);
    }

    public static void v(String subTag, Object message, Throwable throwable) {
        getInstance().logger.v(subTag, message, throwable);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void d(Object message) {
        getInstance().logger.d(null, message, null);
    }

    public static void d(String subTag, Object message) {
        getInstance().logger.d(subTag, message, null);
    }

    public static void d(Throwable throwable) {
        getInstance().logger.d(null, null, throwable);
    }

    public static void d(String subTag, Throwable throwable) {
        getInstance().logger.d(subTag, null, throwable);
    }

    public static void d(String subTag, Object message, Throwable throwable) {
        getInstance().logger.d(subTag, message, throwable);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void i(Object message) {
        getInstance().logger.i(null, message, null);
    }

    public static void i(String subTag, Object message) {
        getInstance().logger.i(subTag, message, null);
    }

    public static void i(Throwable throwable) {
        getInstance().logger.i(null, null, throwable);
    }

    public static void i(String subTag, Throwable throwable) {
        getInstance().logger.i(subTag, null, throwable);
    }

    public static void i(String subTag, Object message, Throwable throwable) {
        getInstance().logger.i(subTag, message, throwable);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void w(Object message) {
        getInstance().logger.w(null, message, null);
    }

    public static void w(String subTag, Object message) {
        getInstance().logger.w(subTag, message, null);
    }

    public static void w(Throwable throwable) {
        getInstance().logger.w(null, null, throwable);
    }

    public static void w(String subTag, Throwable throwable) {
        getInstance().logger.w(subTag, null, throwable);
    }

    public static void w(String subTag, Object message, Throwable throwable) {
        getInstance().logger.w(subTag, message, throwable);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void e(Object message) {
        getInstance().logger.e(null, message, null);
    }

    public static void e(String subTag, Object message) {
        getInstance().logger.e(subTag, message, null);
    }

    public static void e(Throwable throwable) {
        getInstance().logger.e(null, null, throwable);
    }

    public static void e(String subTag, Throwable throwable) {
        getInstance().logger.e(subTag, null, throwable);
    }

    public static void e(String subTag, Object message, Throwable throwable) {
        getInstance().logger.e(subTag, message, throwable);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void json(String json) {
        getInstance().logger.json(null, null, json);
    }

    public static void json(String subTag, String json) {
        getInstance().logger.json(subTag, null, json);
    }

    public static void jsonWithTitle(String title, String json) {
        getInstance().logger.json(null, title, json);
    }

    public static void jsonWithTitle(String subTag, String title, String json) {
        getInstance().logger.json(subTag, title, json);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void xml(String xml) {
        getInstance().logger.xml(null, null, xml);
    }

    public static void xml(String subTag, String xml) {
        getInstance().logger.xml(subTag, null, xml);
    }

    public static void xmlWithTitle(String title, String xml) {
        getInstance().logger.xml(null, title, xml);
    }

    public static void xmlWithTitle(String subTag, String title, String xml) {
        getInstance().logger.xml(subTag, title, xml);
    }
}
