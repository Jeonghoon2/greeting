package com.jeong.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@Slf4j
public class GreetingController {

    private final List<String> nameList = new CopyOnWriteArrayList<>();

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("nameList", nameList);
        return "greeting";
    }

    @PostMapping("/greeting/register")
    public ResponseEntity<String> register(@RequestBody String name) {
        if (name != null && !name.isEmpty()) {
            nameList.add(name);
            return ResponseEntity.ok("이름이 성공적으로 등록되었습니다.");
        }
        return ResponseEntity.badRequest().body("이름을 입력하세요.");
    }
}
