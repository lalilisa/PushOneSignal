package com.trimv.pushonesignal.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "app")
public class AppConf {

    private OneSignal oneSignal;
    @Data
    public static class OneSignal {
        private String appId;
        private String restApiKey;
        private OneSignalApi api;
        private OneSignalStatusCode statusCode;
    }

    @Data
    public static class OneSignalApi {
        private String createNotification;
    }

    @Data
    public static class OneSignalStatusCode{
        List<Integer> success;
        List<Integer> error;
    }
}
