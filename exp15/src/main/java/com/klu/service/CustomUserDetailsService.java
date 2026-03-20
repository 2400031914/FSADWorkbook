package com.klu.service;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.klu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
@Service
public class CustomUserDetailsService implements UserDetailsService{
@Autowired
private UserRepo repo;
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
var user=repo.findByUsername(username).orElseThrow();
return new org.springframework.security.core.userdetails.User(
user.getUsername(),
user.getPassword(),
Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
);
}
}