package com.trimv.pushonesignal.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/callback")
public class CallbackController {

    @PostMapping(path = "/oneSignalDisplayWeb")
    public ResponseEntity<?> callBack(@RequestBody Map<String,Object> body){
        log.info("body {}",body);
        return ResponseEntity.ok(new HashMap<>());
    }
}
