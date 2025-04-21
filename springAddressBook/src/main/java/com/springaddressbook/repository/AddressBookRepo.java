package com.springaddressbook.repository;

import com.springaddressbook.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends JpaRepository<UserEntity,Long> {
}
