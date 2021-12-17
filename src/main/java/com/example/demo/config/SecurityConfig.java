package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
	    public void configure(WebSecurity web) throws Exception {
	      web
	        .ignoring()
	          .antMatchers("/webjars/**")
	          .antMatchers("/css/**")
	          .antMatchers("/js/**");
	 }
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
            .authorizeRequests()//アクセス許可設定
                .antMatchers("/Top").permitAll()//トップページ直接アクセス許可
                .antMatchers("/Login").permitAll()//ログインページ直接アクセス許可
                .antMatchers("/Register").permitAll()//会員登録ページ直接アクセス許可
                .anyRequest().authenticated();//全パス認証必須
        http
            .formLogin()//フォームの認証処理
                .loginProcessingUrl("/Login") //認証のトリガー
                .loginPage("/Login")//認証を行うページ
                .failureUrl("/Login?error")//認証失敗時のページ
                .usernameParameter("name")//認証に使用する情報
                .passwordParameter("password")
                .defaultSuccessUrl("/Create",true);//成功時の遷移先
        
        http
            .logout()//ログアウト処理
              .logoutUrl("/Logout")//Logout 用 formの送信先と紐づけ
              .logoutSuccessUrl("/Top?Logout");
        
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService)//loadUserByUsername で取得した情報を元に認証
      .passwordEncoder(passwordEncoder());
      
      /*
      auth.inMemoryAuthentication()
      .withUser("nagasaka")
        .password(encoder.encode("nagasaka0928"))
        .roles("admin");
      */
    }
  }