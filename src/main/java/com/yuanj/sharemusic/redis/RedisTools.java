package com.yuanj.sharemusic.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


//@Component
public class RedisTools {

    @Value("${spring.redis.host}")
    static String redisHost;

    RedisTools(){
        Jedis jedis=new Jedis(redisHost);
        jedis.set("username","yuanj");
        System.out.println(jedis.get("username"));
    }
    public static void main(String[] args) {
            Jedis jedis=new Jedis("193.112.152.51");
//            jedis.auth("yuanjing");
            jedis.set("username","yuanj");
            System.out.println(jedis.get("username"));
    }

}
