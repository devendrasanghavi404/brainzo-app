package com.stackroute.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.boot.jaxb.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import com.stackroute.Exception.InvalidCredentialException;
import com.stackroute.JwtUtil.JwtUtil;
import com.stackroute.Model.AuthRequest;
import com.stackroute.Model.UserDao;
import com.stackroute.Service.UserAuthenticationService;

@RestController
@RequestMapping("/api/v1")
public class UserAuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthenticationService userService;

    @GetMapping("/")
    public String welcome() {

        return "Testing url.";
    }

    @PostMapping("/authenticate")
    public Map generateToken(@RequestBody AuthRequest authRequest) throws Exception {
       try {
    	   UserDao user= userService.userValidation(authRequest.getEmail(), authRequest.getPassword());
    	   authRequest.setUserRole(user.getUserRole());
    	   SimpleGrantedAuthority authority = new SimpleGrantedAuthority(authRequest.getUserRole().toString());
           List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
           updatedAuthorities.add(authority);
           
            authenticationManager.authenticate(        //Collection<SimpleGrantedAuthority> oldAuthorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();

                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword(),updatedAuthorities)
            );
        } 
       catch (Exception ex) {
            throw new InvalidCredentialException("Invalid username or password");
       
       }
       String token=jwtUtil.generateToken(authRequest.getEmail());
       Map<String, Object> claims = new HashMap<>();
      claims.put("token", token);
      claims.put("role", authRequest.getUserRole());
      return claims;


    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<UserDao> addUser(@RequestBody UserDao user){
        System.out.println("In the post mapping");
        UserDao returnedUser = userService.addUser(user);
        return new ResponseEntity<UserDao>(returnedUser, HttpStatus.OK);
    }
    
}
