package com.jzl.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zalej
 */
@SpringBootApplication
@MapperScan("com.jzl.play.mapper")
@EnableCaching
@EnableTransactionManagement
public class PlaySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaySpringApplication.class, args);
    }

}
