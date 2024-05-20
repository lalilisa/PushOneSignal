package com.trimv.pushonesignal.model.rest.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Subscriptions {

    private String id;
    @JsonProperty("app_id")
    private String appId;
    private String token;
    private String type;
    private boolean enabled;

}
