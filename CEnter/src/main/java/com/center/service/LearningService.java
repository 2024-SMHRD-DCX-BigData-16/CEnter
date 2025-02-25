package com.center.service;

import org.springframework.stereotype.Service;

@Service
public class LearningService {

    public String JavaLesson() {
        return "Java언어를 학습합니다.";
    }

    public String PythonLesson() {
        return "Python언어를 학습합니다.";
    }

    public String HtmlLesson() {
        return "HTML언어를 학습합니다.";
    }

    public String JavaScriptLesson() {
        return "JavaScript언어를 학습합니다.";
    }

    public String CLesson() {
        return "C언어를 학습합니다.";
    }
}
