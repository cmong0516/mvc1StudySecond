package com.example.demo;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3{
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
