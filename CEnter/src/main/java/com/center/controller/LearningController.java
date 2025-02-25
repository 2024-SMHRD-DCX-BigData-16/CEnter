package com.center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // RestController -> Controller로 변경
@RequestMapping("/learning")
public class LearningController {

    @GetMapping("")
    public String showLearningPage() {
        return "ClassMain";  // templates/ClassMain.html을 반환
    }
}





