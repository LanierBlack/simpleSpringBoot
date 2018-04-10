package com.lanierblack.common;

/**
 * 静态常量类
 * @author sunjq
 *
 */
public class Constant {

    protected Constant() {}

    /**
     * 天毫秒数
     */
    public static final long DATE_COUNT = 24 * 60 * 60 * 1000;

    /**
     * 符号br
     */
    public static final String HTML_NEW_LINE = "<br>";


    /**
     * 返回响应状态量
     */
    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    /**
     * 返回响应状态量
     */
    public static final String SUCCESS_MSG = "success";
    public static final String ERROR_MSG = "error";

}