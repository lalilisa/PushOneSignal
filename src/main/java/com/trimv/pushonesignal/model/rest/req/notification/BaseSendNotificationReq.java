package com.trimv.pushonesignal.model.rest.req.notification;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.trimv.pushonesignal.model.rest.common.Languages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public abstract class BaseSendNotificationReq {

    @JsonProperty("app_id")
    private String appId;
    private Map<String,Object> data;
    private Languages contents;
    @JsonProperty("heading")
    private Languages titles;
}
