package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.object.User;

@Mapper //自動的にMapperとしてDIコンテナに登録
public interface UserMapper{
  public void register(User user);
}