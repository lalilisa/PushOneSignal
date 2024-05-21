package com.trimv.pushonesignal.model.rest.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseRes<T> {

    private Integer statusCode;
    private boolean isError = false;
    private T data;
    private List<Object> errors = new ArrayList<>();
}
