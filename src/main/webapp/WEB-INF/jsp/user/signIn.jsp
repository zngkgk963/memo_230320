<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="login-box">
		<h1 class="mb-4">로그인</h1>
		
		<%-- 키보드 Enter키로 로그인이 될 수 있도록 form 태그를 만들어준다.(submit 타입의 버튼이 동작됨) --%>
		<form id="loginForm" action="/user/sign_in" method="post">
			<div class="input-group mb-3">
				<%-- input-group-prepend: input box 앞에 ID 부분을 회색으로 붙인다. --%>
				<div class="input-group-prepend">
					<span class="input-group-text">ID</span>
				</div>
				<input type="text" class="form-control" id="loginId" name="loginId">
			</div>
	
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">PW</span>
				</div>
				<input type="password" class="form-control" id="password" name="password">
			</div>
			
			<%-- btn-block: 로그인 박스 영역에 버튼을 가득 채운다. --%>
			<input type="submit" id="loginBtn" class="btn btn-block btn-primary" value="로그인">
			<a class="btn btn-block btn-dark" href="/user/sign_up_view">회원가입</a>
		</form>
	</div>
</div>
<script>
$(document).ready(function() {
	// 로그인
	$('#loginForm').on('submit', function(e) {
		e.preventDefault(); // form submit 중단
		
		let loginId = $('input[name=loginId]').val().trim();
		let password = $('#password').val();
		
		if (!loginId) {
			alert("아이디를 입력하세요");
			return false;
		}
		if (!password) {
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		let url = $(this).attr('action');
		console.log(url);
		let params = $(this).serialize(); // name 속성 반드시 있어야함
		console.log(params);
		
		$.post(url, params)		// request
		.done(function(data) {  // response
			if (data.code == 1) {
				// 성공
				location.href = "/post/post_list_view"; // 글목록으로 이동
			} else {
				// 로직 실패
				alert(data.errorMessage);
			}
		});
		
	});
})
</script>