package com.likelion.session.controller;

import com.likelion.session.domain.dto.TempReqDto;
import com.likelion.session.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        return "Hello World!" ;
    }


    @PostMapping("/sum/{a}/{b}")
    public int sum(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @PostMapping("/temp")
    public List<Integer> temp(@RequestBody TempReqDto dto) {
        List<Integer> result = testService.temp(dto.getA(), dto.getB());
        return result;

    }
}
