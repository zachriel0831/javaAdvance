package com.ntu.shoppingcart.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.persist.entity.UserEntity;
import com.ntu.shoppingcart.persist.repository.UserRepository;

@Service
public class MyUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUserName(userName);

		if (userEntity == null) {
			throw new UsernameNotFoundException("登入失敗");
		}
		
		List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getRole());
		
		User user = new User();
		user.setAuthorities(authorities);
		user.setPwd("{noop}" + userEntity.getUserPwd()); // 密碼前面加上"{noop}"使用NoOpPasswordEncoder，也就是不對密碼進行任何格式的編碼。
		user.setUserId(userEntity.getUserId());
		user.setUser(userEntity.getUserName());
		
		return user;
	}

}
