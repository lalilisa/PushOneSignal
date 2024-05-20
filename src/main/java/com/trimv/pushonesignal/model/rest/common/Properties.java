package com.trimv.pushonesignal.model.rest.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {

    private static final long serialVersionUID = 1L;


    private Map<String, Object> tags = null;


    private String language;

    @JsonProperty("timezone_id")
    private String timezoneId;

    private BigDecimal lat;

    @JsonProperty("long")
    private BigDecimal _long;


    private String country;


    @JsonProperty("first_active")
    private BigDecimal firstActive;


    @JsonProperty("last_active")
    private BigDecimal lastActive;

    @JsonProperty("amount_spent")
    private BigDecimal amountSpent;

//    @JsonProperty("purchases")
//    private List<Purchase> purchases = null;

    public static final String SERIALIZED_NAME_IP = "ip";
    @JsonProperty("ip")
    private String ip;
}
