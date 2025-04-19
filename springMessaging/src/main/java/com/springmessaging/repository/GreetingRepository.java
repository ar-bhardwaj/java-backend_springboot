package com.springmessaging.repository;

import com.springmessaging.entities.GreetingEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GreetingRepository extends JpaRepository<GreetingEntities,Long> {
}
