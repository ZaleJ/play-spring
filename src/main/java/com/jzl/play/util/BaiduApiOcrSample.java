package com.jzl.play.util;

import com.baidu.aip.ocr.AipOcr;
import org.apache.kafka.common.protocol.types.Field;
import org.json.JSONObject;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author ：jizhaolun
 * @date ：Created in 2019/9/9 17:35
 * @description：
 * @modified By：
 * @version: $
 */
public class BaiduApiOcrSample {
    //设置APPID/AK/SK
    public static final String APP_ID = "17211239";
    public static final String API_KEY = "u7kbXPuOPX9BVXiGoTrpE4Bd";
    public static final String SECRET_KEY = "laEHHrEc0cqgX8AthQcIiYwmPGydvv80";

    // 初始化一个AipOcr
    static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    {

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    public static void main(String[] args) {


        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "C:\\Users\\BUG季\\Desktop/log4j.properties");

        // 调用接口
//        String path = "C:\\Users\\BUG季\\Documents\\Tencent Files\\947703213\\FileRecv\\MobileFile\\test.jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));


        String path = "C:\\Users\\BUG季\\Documents\\Tencent Files\\947703213\\FileRecv\\MobileFile\\test.jpg";
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "true");
        byte[] file = readFile("C:\\Users\\BUG季\\Documents\\Tencent Files\\947703213\\FileRecv\\MobileFile\\test.jpg");

        JSONObject res = client.idcard(file,"front", options);

        // 获取名为words_result的JSONObject
        JSONObject words_result = res.getJSONObject("words_result");

        // 获取姓名
        JSONObject name = words_result.getJSONObject("姓名");
        String nameWords = name.getString("words");
        System.out.println("季兆伦获取的姓名为："+nameWords);

        // 获取性别
        JSONObject sex = words_result.getJSONObject("性别");
        String sexWords = sex.getString("words");
        System.out.println("季兆伦获取的性别为："+sexWords);

        // 获取民族
        JSONObject nation = words_result.getJSONObject("民族");
        String nationWords = nation.getString("words");
        System.out.println("季兆伦获取的民族为："+nationWords);


        // 获取出生年月日
        JSONObject birthday = words_result.getJSONObject("出生");
        String birthdayWords = birthday.getString("words");
        System.out.println("季兆伦获取的出生年月日为："+birthdayWords);

        // 获取住址
        JSONObject address = words_result.getJSONObject("住址");
        String addressWords = address.getString("words");
        System.out.println("季兆伦获取的住址为："+addressWords);

        // 获取公民身份号码
        JSONObject IdNumber = words_result.getJSONObject("公民身份号码");
        String IdNumberWords = IdNumber.getString("words");
        System.out.println("季兆伦获取的公民身份号码为："+IdNumberWords);

        // 获取异常信息
        String riskType = res.getString("risk_type");
        System.out.println("季兆伦获取的异常信息为："+riskType);

        // 获取图片识别状态
        String imageStatus = res.getString("image_status");
        System.out.println("季兆伦获取的图片识别状态为："+imageStatus);


//        System.out.println(res.toString(2));
    }




    public void sample(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地路径
        String image = "C:\\Users\\BUG季\\Documents\\Tencent Files\\947703213\\FileRecv\\MobileFile\\test.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res.toString(2));

        // 参数为二进制数组
        byte[] file = readFile("C:\\Users\\BUG季\\Documents\\Tencent Files\\947703213\\FileRecv\\MobileFile\\test.jpg");
        res = client.idcard(file, idCardSide, options);
        System.out.println(res.toString(2));
    }



    public static byte[] readFile(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (Exception ex1) {
            ex1.printStackTrace();
        }

        return data;
    }

}
