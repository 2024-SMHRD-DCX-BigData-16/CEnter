package com.center.mapper;

import java.util.List;
import com.center.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {

    // AI 답변 저장
    void insertAnswer(Answer answer);

    // 특정 질문의 모든 답변 조회
    List<Answer> getAnswersByQuestion(int qes_idx);
}
