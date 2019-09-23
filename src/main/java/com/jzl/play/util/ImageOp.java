package com.jzl.play.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：jizhaolun
 * @date ：Created in 2019/9/9 18:04
 * @description： 关于图片的各种操作
 * @modified By：
 * @version: $
 */
public class ImageOp {
    public static byte[] readFile(String imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理

        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return Base64.encodeBase64(data);
    }
}
