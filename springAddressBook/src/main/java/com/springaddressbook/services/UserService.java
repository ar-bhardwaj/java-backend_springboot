package com.springaddressbook.services;

import com.springaddressbook.entities.UserEntity;
import com.springaddressbook.repository.AddressBookRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AddressBookRepo urepo;


    public ResponseEntity<String> addUser(UserEntity user) {
    urepo.save(user);
    return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

}
