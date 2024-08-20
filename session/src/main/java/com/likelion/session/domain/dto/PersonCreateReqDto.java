package com.likelion.session.domain.dto;

import lombok.Getter;

@Getter
public class PersonCreateReqDto {
    private String userId;
    private String password;
    private String name;
    private int age;

}
