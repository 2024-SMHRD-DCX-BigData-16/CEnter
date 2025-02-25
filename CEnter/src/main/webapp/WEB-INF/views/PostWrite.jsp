<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
			<div id = "board">
				<form action="postinsert" method="post">
				<table id="list">
					<tr>
						<td>제목</td>
						<td><input type="text" name="post_title"> </td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input value="${loggedInUser.mb_id}" type="text" name="mb_id"> </td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2">
							<input  type="file" name="post_file" style="float: right;">
							<textarea name="post_content" rows="10" style="resize: none;"></textarea>			
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="reset" value="초기화">
							<input type="submit" value="작성하기">
						</td>
					</tr>
				</table>
				</form>
			</div>

</body>
</html>