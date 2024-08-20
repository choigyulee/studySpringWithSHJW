package com.likelion.session.service;

import com.likelion.session.domain.dto.PersonCreateReqDto;
import com.likelion.session.domain.dto.PersonLogin;
import com.likelion.session.domain.entity.Person;
import com.likelion.session.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void createPerson(PersonCreateReqDto dto) {
    Person selectedPerson = personRepository.findByUserId(dto.getUserId());
    if (selectedPerson != null) {
        throw new RuntimeException("중복된 userId가 존재합니다");
    }

        Person p = new Person();
        p.setName(dto.getName());
        p.setUserId(dto.getUserId());
        p.setPassword(dto.getPassword());
        p.setAge(dto.getAge());

        personRepository.save(p);
    }

    public String findUserName(String userId) {
        Person selectedPerson = personRepository.findByUserId(userId);
        if (selectedPerson == null) {
            throw new RuntimeException("해당 userId를 가진 유저가 존재하지 않습니다");
        }
        return selectedPerson.getName();
    }

    public Long login(PersonLogin dto) {
        String userId = dto.getUserId();
        String password = dto.getPassword();

        Person selectedPerson = personRepository.findByUserIdAndPassword(userId, password);
        if (selectedPerson == null) {
            throw new RuntimeException("아이디 또는 비밀번호가 잘못되었습니다");
        }

    return selectedPerson.getId();

    }
}
