package com.trimv.pushonesignal.model.rest.res.user;

import com.trimv.pushonesignal.model.rest.common.Identity;
import com.trimv.pushonesignal.model.rest.common.Properties;
import com.trimv.pushonesignal.model.rest.common.Subscriptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRes {
   private Identity identity;
   private List<Subscriptions> subscriptions;
   private Properties properties;
}
