package com.example.tutorial.controller;

import com.example.tutorial.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("user")
    public ResponseEntity getUser(){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        List<String> user = userMapper.getUser();

        try {
            res.put("status","SUCCESS");
            res.put("messages", "OK");
            res.put("Total", user.size());
            res.put("Data", user);
        } catch (Exception e){
            res.put("status","FAILED");
            res.put("messages","ERROR");

            return ResponseEntity.badRequest().body(res);
        }

        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity getTest(){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("status", "SUCCESS");
        res.put("messages", "Welcome Spring Boot");

        return ResponseEntity.ok(res);
    }

}
