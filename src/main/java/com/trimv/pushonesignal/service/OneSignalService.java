package com.trimv.pushonesignal.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trimv.pushonesignal.config.AppConf;
import com.trimv.pushonesignal.model.rest.common.Properties;
import com.trimv.pushonesignal.model.rest.common.Subscriptions;
import com.trimv.pushonesignal.model.rest.req.CreateUserOneSignal;
import com.trimv.pushonesignal.model.rest.req.ExternalUserId;
import com.trimv.pushonesignal.model.rest.res.BaseRes;
import com.trimv.pushonesignal.model.rest.res.CreateUserRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;


@RequiredArgsConstructor
@Service
@Slf4j
public class OneSignalService {

    private final AppConf appConf;
    private final ObjectMapper objectMapper;
    private final RestClientService restClientService;

    public void createUser() {
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost httpPost = new HttpPost();
//        httpPost.setHeaders(createHeaders().toArray(new Header[0]));
//        HttpEntity  httpEntity = new Obje
//        httpPost.setEntity();
//        httpClient.execute(httpPost,httpResponse -> {
//            return  null;
//        });
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String content = "{\"identity\":{\"external_id\":\"132\"}}";
        RequestBody requestBody = RequestBody.create(content, mediaType);

        Request request = new Request.Builder()
                .url("https://api.onesignal.com/apps/" + appConf.getOneSignal().getAppId() + "/users")
                .post(requestBody)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                log.error("", e);

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }

    @PostConstruct
    public void testCreateUser() throws Exception {
//        createUser();
        Headers headers = new Headers.Builder()
                .add("accept", "application/json")
                .add("content-type", "application/json").build();
        String url = "https://api.onesignal.com/apps/" + appConf.getOneSignal().getAppId() + "/users";
        Subscriptions subscriptions = Subscriptions.builder()
                .type("ChromePush")
                .token("13212313212313")
                .enabled(true)
                .build();
        CreateUserOneSignal createUserOneSignal = CreateUserOneSignal.builder()
                .identity(new ExternalUserId("1999"))
                .properties(new Properties())
                .subscriptions(Collections.singletonList(subscriptions))
                .build();
        BaseRes<CreateUserRes> res = restClientService.processRequest(url, "POST", headers, new HashMap<>(), createUserOneSignal, CreateUserRes.class);
        log.info("res {}", res);
    }


}
