package com.mzll.test.aliyunn;

import com.mzll.test.aliyunn.update.VODConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(VODConfig.class)
//@ComponentScan(basePackages = {"com.mzll.test.aliyunn"})
public class AliyunnApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliyunnApplication.class, args);
    }

}
