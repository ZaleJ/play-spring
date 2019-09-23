package com.jzl.play.model;

/**
 * @author ：jizhaolun
 * @date ：Created in 2019/9/9 20:35
 * @description：百度文字转换接口文字返回json结果
 * @modified By：
 * @version: $
 */
public class BaiduWordResult {
    private String words;
    private BaiduWorkResultLocation location;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public BaiduWorkResultLocation getLocation() {
        return location;
    }

    public void setLocation(BaiduWorkResultLocation location) {
        this.location = location;
    }
}
