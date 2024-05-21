package com.trimv.pushonesignal.model.rest.req.notification;


import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class IncludeAliases {


    public static Map<String,List<String>> createInclueAliasReq(String aliasName,List<String> aliasValues){
        Map<String,List<String>> o = new HashMap<>();
        o.put(aliasName,aliasValues);
        return o;
    }
    public static Map<String,List<String>> createInclueAliasReq(String aliasName,String ...values){
        Map<String,List<String>> o = new HashMap<>();
        o.put(aliasName, Arrays.asList(values));
        return o;
    }
}
