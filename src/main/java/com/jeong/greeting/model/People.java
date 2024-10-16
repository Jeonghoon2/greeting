package com.jeong.greeting.model;

import lombok.Data;
import lombok.ToString;

@ToString
public class People {

    private Integer num;
    private String name;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People() {
    }

    public People(Integer num, String name) {
        this.num = num;
        this.name = name;
    }
}
