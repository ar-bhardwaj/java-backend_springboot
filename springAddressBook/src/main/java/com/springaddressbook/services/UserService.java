package com.springaddressbook.services;

import com.springaddressbook.entities.UserEntity;
import com.springaddressbook.repository.AddressBookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

//@Slf4j
@Service
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class.getName());

    @Autowired
    private AddressBookRepo urepo;

    //add method
    public ResponseEntity<String> addUser(UserEntity user) {
        log.info("Attempting to add a new user");
    urepo.save(user);
    log.info("User successfully added");
    return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    //view by id method
    public ResponseEntity<?>viewUser(Long id) {
        log.info("Attempting to view a user");
        Optional<UserEntity> opt = urepo.findById(id);
        if(opt.isPresent()){
            log.info("User found");
            UserEntity ue=opt.get();

            return new ResponseEntity<>(ue, HttpStatus.OK);
        }
        else{
            log.info("User not found");
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    //edit method
    public ResponseEntity<String> editUser(Long id,UserEntity user){
        log.info("Request to update a user with id");
       Optional<UserEntity> opt = urepo.findById(id);
       if(opt.isPresent()){
           log.info("User found. Proceeding with update...");
           UserEntity ue=opt.get();
           ue.setName(user.getName());
           ue.setAddress(user.getAddress());
           ue.setPhone(user.getPhone());
           ue.setCity(user.getCity());
           urepo.save(ue);
           log.info("User successfully updated");
           return new ResponseEntity<>("User edited successfully", HttpStatus.OK);
       }
       else{
           log.info("User not found with id");
           return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
       }
    }

    //delete method
    public ResponseEntity<String> deleteUser(Long id,UserEntity user) {
        log.info("Request to delete a user with id");
        Optional<UserEntity> opt = urepo.findById(id);
        if(opt.isPresent()){
            log.info("User found. Proceeding with delete");
            UserEntity ue=opt.get();
            urepo.delete(ue);
            log.info("User successfully deleted");
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }
        else{
            log.info("User not found with id");
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
