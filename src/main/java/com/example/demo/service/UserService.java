package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.object.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {

@Autowired UserMapper mapper;
  public void Insert(User user){
    mapper.register(user);
  }
}

