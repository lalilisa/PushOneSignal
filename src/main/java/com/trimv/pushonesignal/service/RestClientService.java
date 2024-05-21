package com.trimv.pushonesignal.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trimv.pushonesignal.config.AppConf;
import com.trimv.pushonesignal.model.rest.res.BaseRes;
import com.trimv.pushonesignal.model.rest.res.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import okhttp3.*;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class RestClientService {

    private final OkHttpClient client = new OkHttpClient();
    private final AppConf appConf;
    private final ObjectMapper objectMapper;

    public <P, B, R> BaseRes<R> processRequest(String url, String method, Headers headers, P params, B body, Class<R> resClazz) throws Exception {
        long t = System.currentTimeMillis();
        Request request = new Request.Builder()
                .url(createQueryParamUrl(url, params))
                .method(method, HttpMethod.GET.name().equals(method) ? null : createRequestBody(body))
                .headers(headers)
                .build();
        log.info(" start call api {}", url);
        Response response = client.newCall(request).execute();
        String bodyJsonStr = Objects.requireNonNull(response.body()).string();
        if (appConf.getOneSignal().getStatusCode().getSuccess().contains(response.code())) {
            log.info("call api {} took {} with res {}", url, System.currentTimeMillis() - t, bodyJsonStr);
            R data = objectMapper.readValue(bodyJsonStr, resClazz);
            BaseRes<R> res = new BaseRes<>();
            res.setError(false);
            res.setStatusCode(response.code());
            res.setData(data);
            return res;
        } else {
            log.error("call api {} took {} with res {}", url, System.currentTimeMillis() - t, bodyJsonStr);
            BaseRes<R> res = new BaseRes<>();
            res.setError(true);
            res.setStatusCode(response.code());
            Map errors = objectMapper.readValue(bodyJsonStr, HashMap.class);
            res.setErrors((List<Object>) errors.get("errors"));
            return res;
        }
    }

    private <P> HttpUrl createQueryParamUrl(String url, P param) {
        Map<String, Object> mapParam = objectMapper.convertValue(param, Map.class);
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        for (Map.Entry<String, Object> entry : mapParam.entrySet()) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
        }
        return urlBuilder.build();
    }

    private <B> RequestBody createRequestBody(B body) throws Exception {
//        Map<String,Object> bodyMap = body !=null ? objectMapper.convertValue(body,Map.class) : new HashMap<>();
        String jsonBody = body != null ? objectMapper.writeValueAsString(body) : "{}";
        return RequestBody.create(jsonBody, MediaType.parse("application/json"));
    }

    @PostConstruct
    public void init() {
        System.out.println(appConf.getOneSignal());
    }

}
