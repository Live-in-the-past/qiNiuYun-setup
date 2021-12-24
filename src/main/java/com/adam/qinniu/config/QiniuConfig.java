package com.adam.qinniu.config;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QiniuConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(QiniuConfig.class);
    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.zone}")
    private String zone;

    @Bean
    public com.qiniu.storage.Configuration Config() {
        switch (zone) {
            case "huadong":
                return new com.qiniu.storage.Configuration(Zone.huadong());
            case "huabei":
                return new com.qiniu.storage.Configuration(Zone.huabei());
            case "huanan":
                return new com.qiniu.storage.Configuration(Zone.huanan());
            case "beimei":
                return new com.qiniu.storage.Configuration(Zone.beimei());
            default:
                LOGGER.info("something wrong! ");
                return null;
        }
    }

    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(Config());
    }

    @Bean
    public Auth auth() {
        return Auth.create(accessKey, secretKey);
    }

    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(), Config());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
