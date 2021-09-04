package com.sparta.week02.domain.Person;

import lombok.Getter;

@Getter
public class PersonRequestDto {
    private String name;
    private String job;
    private int age;
    private String address;
}