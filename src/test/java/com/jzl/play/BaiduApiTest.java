package com.jzl.play;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opencv.core.Core;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaiduApiTest {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
    }
    @Test
    public void contextLoads() {

    }

}
