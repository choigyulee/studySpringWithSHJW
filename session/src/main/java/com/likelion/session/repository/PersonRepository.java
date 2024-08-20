package com.likelion.session.repository;

import com.likelion.session.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUserId(String userId);

    Person findByUserIdAndPassword(String userId, String password);

}
