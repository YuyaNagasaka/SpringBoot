package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Autowired UserDetailsService userDetailsService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
            .authorizeRequests()//アクセス設定
                .antMatchers("/Top").permitAll()//トップページ直接アクセス許可
                .antMatchers("/Login").permitAll()//ログインページ直接アクセス許可
                .antMatchers("/Register").permitAll()//会員登録ページ直接アクセス許可
                .anyRequest().authenticated();//全パス認証必須
        http
            .formLogin()//ログイン処理
                .loginProcessingUrl("/Login") 
                .loginPage("/Login")
                .failureUrl("/Login?error")
                .usernameParameter("name")
                .passwordParameter("password")
                .defaultSuccessUrl("/Create",true);
        
        http.csrf().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      PasswordEncoder encoder = passwordEncoder();
      /*
      auth.inMemoryAuthentication()
      .withUser("nagasaka")
        .password(encoder.encode("nagasaka0928"))
        .roles("admin");
      */
      auth.userDetailsService(userDetailsService)
      .passwordEncoder(encoder);
    }
  }