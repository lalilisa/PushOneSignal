package com.trimv.pushonesignal.model.rest.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Error {
    private String code;
    private String title;
}
