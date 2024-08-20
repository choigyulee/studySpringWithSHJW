package com.likelion.session.controller;

import com.likelion.session.domain.dto.PersonCreateReqDto;
import com.likelion.session.domain.dto.PersonLogin;
import com.likelion.session.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public String creatPerson(@RequestBody PersonCreateReqDto dto) {
        personService.createPerson(dto);
        return "정상적으로 유저가 생성되었습니다.";
    }

    @GetMapping("/person/{userId}")
    public String findUserName(@PathVariable String userId){
        return personService.findUserName(userId);
    }

    @PostMapping("/login")
    public Long login(@RequestBody PersonLogin dto){
        return personService.login(dto);
    }
}
