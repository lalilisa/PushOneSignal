package com.trimv.pushonesignal.model.rest.req.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trimv.pushonesignal.model.rest.common.Languages;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SendMultipleAliasReq extends BaseSendNotificationReq {

    @JsonProperty("target_channel")
    private String targetChannel = "push";
    @JsonProperty("include_aliases")
    private Map<String,List<String>> includeAliases;


    public static SendMultipleAliasReq create(String appId,String aliasName,List<String> value, Languages contents,Languages titles,Map<String,Object> customData){
        return SendMultipleAliasReq.builder()
                .includeAliases(IncludeAliases.createInclueAliasReq(aliasName,value))
                .appId(appId)
                .data(customData)
                .contents(contents)
                .titles(titles)
                .targetChannel("push")
                .build();
    }
}
