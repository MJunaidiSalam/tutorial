package com.example.tutorial.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper  {
    List<String> getUser();
}
