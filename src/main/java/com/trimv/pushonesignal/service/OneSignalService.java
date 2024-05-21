package com.trimv.pushonesignal.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trimv.pushonesignal.config.AppConf;

import com.trimv.pushonesignal.model.rest.common.Languages;
import com.trimv.pushonesignal.model.rest.req.notification.SendMultipleAliasReq;
import com.trimv.pushonesignal.model.rest.res.BaseRes;
import com.trimv.pushonesignal.model.rest.res.notification.CreateNotificationRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Slf4j
public class OneSignalService {

    private final AppConf appConf;
    private final RestClientService restClientService;


    public void sendNotificationByExternalId(List<String> userIds, String titleEn, String titleVn, String contentVi, String contentEn, Map<String, Object> customData) {
        List<String> externalIdValues = userIds.stream().map(Object::toString).collect(Collectors.toList());
        Languages contents = Languages.builder().en(contentEn).vi(contentVi).build();
        Languages titles = Languages.builder().en(titleEn).vi(titleVn).build();
        customData = customData != null ? customData : new HashMap<>();
        SendMultipleAliasReq body = SendMultipleAliasReq.create(appConf.getOneSignal().getAppId(), "external_id", externalIdValues, contents, titles, customData);
        try {
            BaseRes<CreateNotificationRes> res = restClientService.processRequest(
                    appConf.getOneSignal().getApi().getCreateNotification(),
                    HttpMethod.POST.name(),
                    createHeadersOnesignal(),
                    new HashMap<>(), body, CreateNotificationRes.class);
            log.info("res {}",res);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public Headers createHeadersOnesignal() {
        return new Headers.Builder()
                .add("accept", "application/json")
                .add("content-type", "application/json")
                .add("Authorization", "Basic "+ appConf.getOneSignal().getRestApiKey())
                .build();
    }

    @PostConstruct
    public void  test(){
        sendNotificationByExternalId(List.of("cuc237"),"noti","noti","Hello","hello",new HashMap<>());
    }

}
