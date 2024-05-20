package com.trimv.pushonesignal.model.rest.req;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.trimv.pushonesignal.model.rest.common.Properties;
import com.trimv.pushonesignal.model.rest.common.Subscriptions;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserOneSignal {

    @JsonProperty("identity")
    private ExternalUserId identity;
    private List<Subscriptions> subscriptions;
    private Properties properties;
}
