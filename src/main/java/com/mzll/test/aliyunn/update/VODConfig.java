package com.mzll.test.aliyunn.update;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "vod")
@Component
@Data
public class VODConfig {
    private String accessKeyId;
    private String accessKeySecret;
}
