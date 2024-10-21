package com.jeong.greeting;

import com.jeong.greeting.model.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Stack;

@Controller
@Slf4j
public class GreetingController {


    /**
     * 파이썬 문법으로는
     * newList = [] 똑같다
     */
    private final Stack<People> peopleStack = new Stack<>();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false) String name, Model model) {

        /* name 의 값이 들어 올 경우*/
        if (name != null && !name.isEmpty()) {
            Integer num = 0;

            if (peopleStack.isEmpty()) {
                /* 만약 PeopleStack 의 값이 비어 있을 경우 num 의 값을 1로 고정한다.*/
                num = 1;
            } else {
                /* PeopleStack 값이 비어 있지 않을 경우 마지막 값을 불러와 마지막 값의 num 에 + 1을 해준다.*/
                People peek = peopleStack.peek();
                num = peek.getNum() + 1;
            }

            /* 새로운 생성자 생성 */
            People people = new People(num, name);
            peopleStack.add(people);
        }

        model.addAttribute("peopleList", peopleStack);
        log.info(peopleStack.toString());

        return "greeting";
    }

}
