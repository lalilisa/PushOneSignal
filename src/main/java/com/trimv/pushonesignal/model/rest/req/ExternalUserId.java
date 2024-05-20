package com.trimv.pushonesignal.model.rest.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalUserId {

    @JsonProperty("external_id")
    private String externalId;
}
