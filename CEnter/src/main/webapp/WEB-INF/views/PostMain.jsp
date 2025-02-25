<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>Forty by HTML5 UP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="con">
      <h2>게시판</h2>
      <a href="postwrite" class="write">작성</a>
      <div class="postbox">
         <ul>
            <c:forEach var = "list" items="${postList}" varStatus="s">
               <li>
                  <div>${s.count}</div>
                  <a href="postcontent?idx=${list.post_idx}" style="cursor: pointer;">${list.post_title}</a>
                  <div>${list.mb_id}</div>
                  <div>${list.created_at}</div>
               </li>            
            </c:forEach>
         </ul>
      </div>
   </div>
</body>
</html>