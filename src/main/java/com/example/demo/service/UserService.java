package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.object.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {

@Autowired UserMapper mapper;
@Autowired PasswordEncoder encoder;

  public void Insert(User user){
	String password = user.getPassword();
	user.setPassword(encoder.encode(password));//パスワードの暗号化
    mapper.register(user);
  }
  
  public User findUser(String name) {//ログイン情報取得
    return mapper.findUser(name);
  }
}

