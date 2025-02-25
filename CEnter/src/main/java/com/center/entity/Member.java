package com.center.entity; // ✅ 패키지 선언 확인

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
public class Member {
    private String mb_id;

    @NonNull
    private String mb_pw;

    @NonNull
    private String mb_name;

    private int mb_level = 1; // 기본값 1(회원가입 시 자동 적용)

    private int mb_point = 0; // 기본값 0 

    private Timestamp joined_at = new Timestamp(System.currentTimeMillis()); //현재 시간 자동 입력
}
