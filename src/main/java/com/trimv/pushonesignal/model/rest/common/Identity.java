package com.trimv.pushonesignal.model.rest.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Identity {

    @JsonProperty("onesignal_id")
    private String oneSignalId;
    @JsonProperty("external_id")
    private String externalId;
}
