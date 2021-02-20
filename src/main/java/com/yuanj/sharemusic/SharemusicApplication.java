package com.yuanj.sharemusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication()
@EnableAspectJAutoProxy
public class SharemusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharemusicApplication.class, args);
    }

}
