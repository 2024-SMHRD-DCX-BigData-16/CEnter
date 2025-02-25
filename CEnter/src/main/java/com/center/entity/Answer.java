package com.center.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Answer {
    private int ans_idx;
    
    @NonNull
    private String mb_id; // 사용자 ID
    
    private int ai_idx;  // AI 응답 ID (예: AI 모델 종류)
    
    @NonNull
    private int qes_idx; // 질문 ID
    
    private Timestamp created_at;
    
    private char ans_yn; // 답변 승인 여부 ('Y' 또는 'N')
    
    @NonNull
    private String ans_problem; // AI가 생성한 답변
}
