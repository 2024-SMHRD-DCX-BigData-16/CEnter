package com.center.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.center.entity.Member;

@Mapper
@Repository
public interface MemberMapper {

    // 회원가입 (원래 있던 코드 그대로 유지)
    public void memberInsert(Member member); 

    // 로그인 (아이디 + 비밀번호로 회원 조회)
    Member memberLogin(@Param("mb_id") String mb_id, @Param("mb_pw") String mb_pw);
    
    
    
   
}
