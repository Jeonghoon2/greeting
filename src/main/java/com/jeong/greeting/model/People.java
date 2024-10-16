package com.jeong.greeting.model;

import lombok.Data;

@Data
public class People {

    private Integer num;
    private String name;

    public People(Integer num, String name) {
        this.num = num;
        this.name = name;
    }
}
