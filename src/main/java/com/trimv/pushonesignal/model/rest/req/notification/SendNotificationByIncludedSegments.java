package com.trimv.pushonesignal.model.rest.req.notification;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SendNotificationByIncludedSegments extends BaseSendNotificationReq {

    @JsonProperty("included_segments")
    private List<String> includedSegments = new ArrayList<>();
}
