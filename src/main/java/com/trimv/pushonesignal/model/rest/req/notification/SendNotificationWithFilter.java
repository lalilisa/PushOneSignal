package com.trimv.pushonesignal.model.rest.req.notification;

import com.trimv.pushonesignal.model.rest.common.Filter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SendNotificationWithFilter extends  BaseSendNotificationReq{

    private List<Filter> filters;



}
