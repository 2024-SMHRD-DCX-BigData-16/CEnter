<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>Forty by HTML5 UP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/assets/css/main.css?v=1.0">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
  <!-- main소개 1 -->
  <div class="con" style="background-image: url(resources/images/background.gif)">
    <div class="header">
      <h3>C<span class="blue">E</span>nter</h3>
      <div class="nav">
        <ul>
          <li><a href="">Home</a></li>
          <li><a href="directory">Directory</a></li>
          <li><a href="learning">Class</a></li>
          <li><a href="postselect">Community</a></li>
          <c:if test="${empty loggedInUser}">
          	<li><button class="login">Sign</button></li>      
          </c:if>
          <c:if test="${not empty loggedInUser}">
          	<li><a href="logout">Logout</a></li>
          </c:if>
        </ul>
      </div>
    </div>
    <div class="text">
      <p>IT전문가를 위한 첫걸음</p>
      <p>지금, <span class="taiping">C<span>E</span>nter에서</span></p>
      <p>C<span class="blue">E</span>nter에서</p>
    </div>
  </div>

  <!-- main 소개 2 -->
  <div class="box">
    <div class="text">
      <h3>어떤 학습을 제공하나요?</h3>
    </div>
    <div class="box-item">
      <div class="item">
        <div class="java" style="background-image: url(resources/images/자바.png);"></div>
        <h4>java</h4>
      </div>
      <div class="item">
        <div class="python" style="background-image: url(resources/images/파이썬.png);"></div>
        <h4>python</h4>
      </div>
      <div class="item">
        <div class="c" style="background-image: url(resources/images/c언어.png);"></div>
        <h4>c언어</h4>
      </div>
      <div class="item">
        <div class="js" style="background-image: url(resources/images/자바스크립트.png);"></div>
        <h4>javaScript</h4>
      </div>
      <div class="item">
        <div class="react" style="background-image: url(resources/images/react.png);"></div>
        <h4>react</h4>
      </div>
      <div class="item">
        <div class="spring" style="background-image: url(resources/images/스프링.png);"></div>
        <h4>spring</h4>
      </div>
      <div class="item">
        <div class="js" style="background-image: url(resources/images/자바스크립트.png);"></div>
        <h4>javaScript</h4>
      </div>
    </div>
    <div class="buttons">
      <span class="prev"></span>
      <span class="next"></span>
    </div>
  </div>
  <!-- main소개 3 -->
  <div class="leg">
    <div class="text">
      <h3 class="qnaContent">
        <p>어떤 학습을 제공하나요?</p>
      </h3>
      <div class="mainContent">
        <p> C<span class="blue">E</span>nter는</p>
        <p>IT 분야의 기반을 다질 수 있는</p>
        <p>학습기회를 제공합니다!</p>
      </div>
      <div class="reContent"></div>
      <p>경제적, 사회적 배경에 상관없이</p>
      <p>누구나 잠재력을 펼칠 수 있는 사회를 만들어 갑니다.</p>
    </div>
    <div class="languIntro">
      <span style="--i:1;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:2;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:3;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:4;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:5;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:6;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:7;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:8;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:9;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:10;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:11;"><i class="fa-solid fa-moon"></i></span>
      <span style="--i:12;"><i class="fa-solid fa-moon"></i></span>
    </div>
  </div>

  <!-- 로그인 창 -->
  <div class="bulbackgro">
    <div class="login">
      <h2>Login</h2>
      <form action="memberLogin" method="post">
        <input type="text" placeholder="Id" name="mb_id" class="logininp">
        <input type="password" placeholder="Password" name="mb_pw" class="logininp">
        <input type="submit" value="Login" class="loginsub">
      </form>
      <p>비밀번호를 잊으셨나요?<a href="#">비밀번호 찾기</a></p>
      <p>계정이 없나요?<button class="sign_up">회원가입</button></p>
    </div>
    <div class="join">
      <h2>Sign up</h2>
      <form action="memberInsert" method="post">
        <input type="text" placeholder="Id" name="mb_id" class="logininp">
        <input type="password" placeholder="Password" name="mb_pw" class="logininp">
        <input type="text" placeholder="Name" name="mb_name" class="logininp">
        <input type="submit" value="Sign up" class="loginsub">
      </form>
    </div>
  </div>

  <script>
    // main 2 학습 앞 뒤 버튼
    const prev = document.querySelector('.prev')
    const next = document.querySelector('.next')

    next.addEventListener('click', () =>{
      let items = document.querySelectorAll('.item')
      document.querySelector('.box-item').appendChild(items[0])
    })
    prev.addEventListener('click', () =>{
      let items = document.querySelectorAll('.item')
      document.querySelector('.box-item').prepend(items[items.length-1])
    })

    // 로그인 블러 처리
    const loginbackgro = document.querySelector(".bulbackgro")
    const loginbox = document.querySelector(".bulbackgro .login")
    const joinbox = document.querySelector(".bulbackgro .join")
    const loginbtn = document.querySelector("button.login")
    const body = document.querySelector("body")
    const navUl = document.querySelector(".con .nav ul")

    loginbtn.addEventListener('click', () => {
      body.style.overflow = 'hidden'
      body.style.paddingRight = '17px'
      navUl.style.display = 'none'
      loginbackgro.style.display = 'flex'
      loginbackgro.classList.add('bulr')
      loginbox.style.transform = 'perspective(800px) rotateY(0deg)'
      joinbox.style.transform = 'perspective(800px) rotateY(180deg)'
    })
    loginbackgro.addEventListener('click', () =>{
      body.style.overflow = 'auto'
      body.style.paddingRight = '0px'
      loginbackgro.style.display = 'none'
      navUl.style.display = 'flex'
      loginbackgro.classList.remove('bulr')
      loginbox.style.transform = 'perspective(800px) rotateY(0deg)'
      joinbox.style.transform = 'perspective(800px) rotateY(180deg)'
    })

    loginbox.addEventListener('click', e =>{
      e.stopPropagation()
    })
    joinbox.addEventListener('click', e =>{
      e.stopPropagation()
    })

    //로그인 에서 회원가입 전환
    const sign_up = document.querySelector(".bulbackgro .login p .sign_up")

    sign_up.addEventListener('click', ()=>{
      loginbox.style.transform = 'perspective(800px) rotateY(180deg)'
      joinbox.style.transform = 'perspective(800px) rotateY(360deg)'
    })

    

  </script>

</body>
</html>