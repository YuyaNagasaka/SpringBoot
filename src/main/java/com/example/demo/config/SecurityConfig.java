package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()//アクセス設定
                .antMatchers("/Top").permitAll()//トップページ直接アクセス許可
                .antMatchers("/Login").permitAll()//ログインページ直接アクセス許可
                .antMatchers("/Register").permitAll()//会員登録ページ直接アクセス許可
                .anyRequest().authenticated();//全パス認証必須
        
    }

}