package com.stackroute.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.Model.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserDao, String> {

    public UserDao findByEmail(String username);
    UserDao findByEmailAndPassword(String email,String password);

}