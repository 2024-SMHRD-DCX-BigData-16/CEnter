package com.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import com.center.entity.Member;
import com.center.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class MemberController {

	@Autowired
	private MemberMapper memberMapper;

    // 메인 페이지
    @RequestMapping("/")
    public String main() {
        return "Main"; // main.jsp 페이지 반환
    }
    

	// 회원가입 페이지
	@GetMapping("/register")
	public String register() {
		return "Register"; // register.jsp 반환
	}

	// 로그인 페이지
	@GetMapping("/login")
	public String Login() {
		return "Login";
	}
	
	
	// 회원가입 요청 처리 (POST 요청)
	@PostMapping("/memberInsert")
	public String memberInsert(@ModelAttribute Member member, RedirectAttributes redirectAttributes) {
		System.out.println("회원가입 요청: " + member.toString());

		try {
			member.setMb_level(1); // 레벨 기본값 1로 설정
			member.setJoined_at(new Timestamp(System.currentTimeMillis())); // 현재 시간 설정

			memberMapper.memberInsert(member);
			System.out.println("회원가입 성공!");
			redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다!");
		} catch (Exception e) {
			System.out.println("DB 저장 실패: " + e.getMessage());
			redirectAttributes.addFlashAttribute("message", "회원가입 실패: " + e.getMessage());
		}

		return "redirect:/";
	}

	// 로그인 요청 처리 (POST 요청)
	@PostMapping("/memberLogin")
	public String memberLogin(@RequestParam String mb_id, @RequestParam String mb_pw, HttpSession session,
			RedirectAttributes redirectAttributes) {
		System.out.println("로그인 요청: ID=" + mb_id);

		// DB에서 회원 정보 조회
		Member member = memberMapper.memberLogin(mb_id, mb_pw);

		if (member != null) {
			session.setAttribute("loggedInUser", member); // 세션 저장
			System.out.println("로그인 성공!");
			return "redirect:/"; // 로그인 성공 → 메인 페이지 이동
		} else {
			System.out.println("로그인 실패: 아이디 또는 비밀번호 불일치");
			redirectAttributes.addFlashAttribute("message", "로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
			return "redirect:/login"; // 로그인 실패 → 다시 로그인 페이지
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 삭제 (로그아웃)
		return "redirect:/"; // 로그아웃 후 메인 페이지 이동
	}
}
