package com.trimv.pushonesignal.model.rest.res.notification;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateNotificationRes {

    @JsonProperty("id")
    private String notificationId;
    @JsonProperty("external_id")
    private String externalId;
}
