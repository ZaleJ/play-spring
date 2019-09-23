package com.jzl.play.model;

/**
 * @author ：jizhaolun
 * @date ：Created in 2019/9/9 20:36
 * @description：百度文字识别类，文字位置
 * @modified By：
 * @version: $
 */
public class BaiduWorkResultLocation {
    private Integer top;
    private Integer left;
    private Integer width;
    private Integer height;

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
