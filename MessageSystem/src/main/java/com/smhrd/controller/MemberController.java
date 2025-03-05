package com.smhrd.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.smhrd.entity.Member;
import com.smhrd.entity.Message;
import com.smhrd.mapper.MemberMapper;
import com.smhrd.mapper.MessageMapper;

// POJO를 찾기위해서 필요한 조건 2가지
// 1. servlet-context.xml 파일에 Controller 명시하기
// 2. 해당 파일에 Controller라고 명시하기
@Controller
public class MemberController {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@RequestMapping("/")
	public String main() {
		return "Main";
	}
	
	@RequestMapping("/goMain")
	public String goMain() {
		return "Main";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser() {
		
		return "UpdateMember";
	}
	@RequestMapping("/emailCheck") // @ResponseBody -> View(화면)이 아니라 데이터를 직접 반환할 때 사용한다!
	public @ResponseBody boolean emailCheck(@RequestParam("inputE") String inputE) {
		// 받아온 이메일을 가지고 데이터베이스에 동일한 email이 있는지 확인
		Member member = memberMapper.emailCheck(inputE);
	
		// member 객체안에는
		// 1. 동일한 email이 있다면 -> 해당 유저의 정보가! -> email 사용 불가
		// 2. 동일한 email이 없다면 -> null값이 있다! -> email 사용 가능

		// boolean 타입으로 되돌려주자!
		if(member == null) {
			// 사용 가능한 이메일
			return true;
		}else {
			// 사용 불가한 이메일
			return false;
		}
		
	}
	
	
	
	
	// 회원가입
	// localhost : 8082/controller/memberInsert
	@RequestMapping("/memberInsert")
	public String memberInsert(Member member, Model model) {// email, pw, tel, address
//		System.out.println(member.toString());
		memberMapper.memberInsert(member);
		model.addAttribute("email", member.getEmail());
		return "JoinSuccess";
	}
	
	// 로그인 기능
	@PostMapping("/memberJoin")
	public String memberJoin(Member member, Model model,  HttpSession session) {
		
		System.out.println(member.toString());
		System.out.println(member.getEmail());
		
		// 컨트롤러에서 요청을 받았다면 DB에 접근하기 위해서 -> 인터페이스 (memberMapper) 호출하기!
		Member loginMember = memberMapper.memberSelectOne(member);
		
		
		if(loginMember == null) {
			// 로그인 실패
			System.out.println("로그인에 실패했습니다 id와 pw를 확인해주세요");
			session.removeAttribute("member");
			return "Main";
		}else {
			// 로그인 성공
			System.out.println(loginMember.toString());
			// Session은 JSP 내장객체 혹은 Servlet에서 호출해야하는 객체
			session.setAttribute("loginuser", loginMember);	
			// 로그인한 유저의 메세지를 전부 출력!
			List<Message> msgList = messageMapper.messageList(loginMember.getEmail());
			session.setAttribute("msgList", msgList);
			
			
			
			return "Main";
		}
		
		
	}
	
	// 회원정보 수정
	@PostMapping("/UpdateMember") // request.getParameter("pw")
	public String updateMember(@RequestParam("pw") String pw, 
								@RequestParam("tel") String tel,
								@RequestParam("address") String address, HttpSession session) {
		
		// 사용자의 정보를 업데이트하기 위해서 email, pw, tel, address
		// session안에는 현재 로그인한 유저의 데이트가 들어있다! -> email을 가지고 올 수 있다!
		
		// 1. email 
		Member loginMember = (Member)session.getAttribute("loginuser");
		String email = loginMember.getEmail();
		
		// 데이터를 전송하기 위해서 Mybatis가 이용할 수 있도록 하나로 묶어줄 것!
		Member member = new Member(email, pw, tel, address);
		
		// DB 요청을 할 수 있도록 -> Mapper 호출
		int result = memberMapper.memberUpdate(member);
		
		if(result > 0) {
			// 회원정보 수정 성공 -> 현재 session안에 있는 유저의 정보와 DB안에 있는 유저의 정보가 다르다!!
			session.setAttribute("loginuser", member);
			return "Main";
		}else {
			// 화원정보 수정 실패
			
			return "UpdateMember";
		}
	}
	
	// 로그아웃 기능
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginuser");
		return "Main";
	}
	
	// ShowMember.jsp로 이동하는 기능 + 전체회원 조회
	@GetMapping("/showMember")
	public String showMember(Model model) {		
		 List<Member> list = memberMapper.showMember();
		 model.addAttribute("list", list);
		
		return "ShowMember";
	}
	
	// admin계정으로 로그인 했을 때 회원삭제하기
	// deleteMember?email=juhue
	@GetMapping("deleteMember")
	public String deleteMember(@RequestParam("email") String email) {
		memberMapper.deleteMember(email);
		// 매개변수로 받아온 email값을 memberMapper 인터페이스에 넘기기
		// 인터페이스에서 deleteMember(String email) 만들기
		// MemberMapper.xml에 id값이 deleteMember인 쿼리 작성
		// MySql 워크벤치에서 select 했을 때 해당 계정이 삭제됐는지 확인하기
		
		return "redirect:/showMember";
	}
	
	
	
	
	
	
}
