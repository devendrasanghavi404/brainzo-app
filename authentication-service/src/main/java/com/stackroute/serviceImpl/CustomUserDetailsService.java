package com.stackroute.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.stackroute.Model.UserDao;
import com.stackroute.Repository.UserAuthenticationRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAuthenticationRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        UserDao user = repository.findByEmail(userName);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole().toString());    //added extra
        List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();              //added extra
        updatedAuthorities.add(authority);                                                                      //added extra

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), updatedAuthorities);
    }

}
