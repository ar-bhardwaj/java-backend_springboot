package com.springaddressbook.services;

import com.springaddressbook.dto.UserDTO;
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
    public ResponseEntity<String> addUser(UserDTO dto) {
        log.info("Adding user"+dto);
        UserEntity u = new UserEntity();
        u.setName(dto.getName());
        u.setAddress(dto.getAddress());
        u.setCity(dto.getCity());
        u.setPhone(dto.getPhone());
        urepo.save(u);

        log.info("User added with dto");
        return new ResponseEntity<>("User ADDED SUCCESSFULLY",HttpStatus.CREATED);
    }

    //view by id method
    public ResponseEntity<?>viewUser(Long id) {
        log.info("Attempting to view a user with dto");

        Optional<UserEntity> opt = urepo.findById(id);
        if(opt.isPresent()){
            log.info("User found with dto");
            UserEntity u = opt.get();
            UserDTO dto = new UserDTO();
            dto.setId(u.getId());
            dto.setName(u.getName());
            dto.setCity(u.getCity());
            dto.setPhone(u.getPhone());
            dto.setAddress(u.getAddress());
            log.info("User viewed with dto");

            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        else{
            log.info("User not found");
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    //edit method
    public ResponseEntity<String> editUser(Long id,UserDTO dto) {
        log.info("Request to update a user with id");
        Optional<UserEntity> opt = urepo.findById(id);
        if(opt.isPresent()){
            log.info("User found. Proceeding with update...");
            UserEntity ue=opt.get();

            ue.setName(dto.getName());
            ue.setAddress(dto.getAddress());
            ue.setPhone(dto.getPhone());
            ue.setCity(dto.getCity());
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
    public ResponseEntity<String> deleteUser(Long id) {
        log.info("Request to delete a user with id");
        Optional<UserEntity> opt = urepo.findById(id);
        if(opt.isPresent()){
            log.info("User found. Proceeding with delete");
            urepo.deleteById(id);
            log.info("User successfully deleted");
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }
        else{
            log.info("User not found with id");
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
