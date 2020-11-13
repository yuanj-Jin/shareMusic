package com.yuanj.sharemusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SharemusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharemusicApplication.class, args);
    }

}
