package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired UserService service;
    @Override
    //loginProcessingUrl で指定されたページにPostリクエストが届いたタイミングで自動実行
    //送信したユーザー情報が存在するか確認
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        
    	com.example.demo.object.User login_user = service.findUser(name);
    	List<GrantedAuthority>authorities = new ArrayList<>();
        //DBにユーザー情報が登録されていなかった場合例外出力
    	if (login_user == null) {
   		 throw new UsernameNotFoundException("user not found");
       }
    	//user.dettails.user 型変数にコンストラクタの戻り値を格納 
    	//user.dettails.user 型クラス以外キャスト出来ない？
    	User Login_user = new User(login_user.getName(),login_user.getPassword(),authorities);
    	UserDetails userDetails = (UserDetails)  Login_user;//認証できる形に変換
    	
    	return userDetails;//認証元に返す
    }
}