package com.dpf.springcloud;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);

        Config config = new Config();
        config.useSingleServer().setAddress("10.0.3.151:6379");
        RedissonClient client = Redisson.create(config);
        

    }
}
