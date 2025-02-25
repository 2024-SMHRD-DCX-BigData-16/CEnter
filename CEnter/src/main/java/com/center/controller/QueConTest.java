package com.center.controller;

import com.center.entity.Question;
import com.center.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/QueConTest")
public class QueConTest {

    @Autowired
    private QuestionMapper questionMapper;

    // 질문 입력 페이지
    @GetMapping("/form")
    public String showForm(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/member/login"; // 로그인 안 하면 로그인 페이지로 이동
        }
        return "questionForm"; // 질문 입력 페이지로 이동
    }

    // 질문 저장 (POST 요청)
    @PostMapping("/add")
    public String addQuestion(@ModelAttribute Question question) {
        System.out.println("✅ 질문 등록 요청 받음: " + question.getQes_content());
        questionMapper.insertQuestion(question);
        return "redirect:/QueConTest/list"; // 저장 후 목록 페이지로 이동
    }

    // 질문 목록 조회
    @GetMapping("/list")
    public String getAllQuestions(Model model) {
        List<Question> questions = questionMapper.getAllQuestions();
        model.addAttribute("questions", questions);
        return "questionList";
    }
}
