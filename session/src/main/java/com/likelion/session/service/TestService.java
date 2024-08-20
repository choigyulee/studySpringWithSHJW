package com.likelion.session.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    public List<Integer> temp(int a, int b) {
        int add = a + b;
        int sub = a - b;

        List<Integer> result = new ArrayList<>();
        result.add(add);
        result.add(sub);
        return result;
    }
}
