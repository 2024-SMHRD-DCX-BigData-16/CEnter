package com.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.center.entity.Question;

@Mapper
public interface QuestionMapper {
    public void insertQuestion(Question question);
    public List<Question> getAllQuestions();
}
