package com.github.yangkangli.x.log.adapter;

import android.text.TextUtils;
import android.util.Log;


import com.github.yangkangli.x.log.core.BaseLogStrategy;
import com.github.yangkangli.x.log.core.ILogAdapter;
import com.github.yangkangli.x.log.utils.Constant;
import com.github.yangkangli.x.log.utils.Utils;

import java.util.List;

/**
 * 控制台日志适配器
 */
public class ConsoleAdapter implements ILogAdapter {

    /**
     * 是否开启打印日志
     */
    private boolean loggable;

    /**
     * 日志策略
     */
    private BaseLogStrategy strategy;

    /**
     * 构造方法
     *
     * @param builder
     */
    private ConsoleAdapter(Builder builder) {
        this.loggable = builder.loggable;
        this.strategy = builder.strategy;
    }


    @Override
    public boolean isLoggable() {
        return loggable;
    }


    @Override
    public void log(int priority, String subTag, String message) {

        // 检查策略是否为空
        Utils.checkNotNull(strategy);

        // 得到完整的Tag
        String tag = getFullTag(strategy, subTag);

        // 上边线
        String topBorder = Utils.getTopBorder(subTag, strategy.getBorderMaxLength(), strategy.getLinkerLength());
        Log.println(priority, tag, topBorder);

        // 线程名称
        if (strategy.isShowThreadName()) {
            String threadName = Constant.VERTICAL_LINE + " Thread:" + Thread.currentThread().getName();
            Log.println(priority, tag, threadName);
            // 分隔线
            String divider = Utils.getDivider(subTag, strategy.getBorderMaxLength(), strategy.getLinkerLength());
            Log.println(priority, tag, divider);
        }

        // 调用堆栈
        if (strategy.isShowStackTrace()) {
            String level = "";
            List<StackTraceElement> traceList = Utils.getTraceList(Thread.currentThread().getStackTrace(), strategy.getMethodCount());
            for (StackTraceElement element : traceList) {
                StringBuilder builder = new StringBuilder();
                builder.append(Constant.VERTICAL_LINE)
                        .append(' ')
                        .append(level)
                        .append(Utils.getSimpleClassName(element.getClassName()))
                        .append(".")
                        .append(element.getMethodName())
                        .append(" ")
                        .append(" (")
                        .append(element.getFileName())
                        .append(":")
                        .append(element.getLineNumber())
                        .append(")");
                level += "    ";
                Log.println(priority, tag, builder.toString());
            }
            // 分隔线
            String divider = Utils.getDivider(subTag, strategy.getBorderMaxLength(), strategy.getLinkerLength());
            Log.println(priority, tag, divider);
        }

        // 消息内容
        String[] strings = Utils.splitMessage(message);
        for (String msg : strings) {
            Log.println(priority, tag, Constant.VERTICAL_LINE + " " + msg);
        }

        // 下边线
        String bottomBorder = Utils.getBottomBorder(subTag, strategy.getBorderMaxLength(), strategy.getLinkerLength());
        Log.println(priority, tag, bottomBorder);
    }

    /**
     * 获得完整的Tag（BaseTag+SubTag）
     *
     * @param strategy
     * @param subTag
     * @return
     */
    private String getFullTag(BaseLogStrategy strategy, String subTag) {
        if (!TextUtils.isEmpty(subTag)) {
            return strategy.getBaseTag() + strategy.getLinker() + subTag;
        }
        return strategy.getBaseTag();
    }

    /**
     * 构造器，用于构造ConsoleAdapter实例
     */
    public static class Builder {
        /**
         * 是否开启打印日志，默认关闭
         */
        private boolean loggable = false;

        /**
         * 日志策略
         */
        private BaseLogStrategy strategy;

        /**
         * 设置是否开启打印日志
         *
         * @param loggable
         * @return
         */
        public Builder setLoggable(boolean loggable) {
            this.loggable = loggable;
            return this;
        }

        public Builder setLogStrategy(BaseLogStrategy strategy) {
            this.strategy = strategy;
            return this;
        }

        /**
         * 构造ConsoleAdapter
         *
         * @return
         */
        public ConsoleAdapter build() {
            return new ConsoleAdapter(this);
        }
    }
}
