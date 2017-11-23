package com.cyq.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @date 2017/11/23
 **/

@MapperScan("com.cyq.bookstore.dao")
@SpringBootApplication
public class ShopDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopDesignApplication.class, args);
    }

}
