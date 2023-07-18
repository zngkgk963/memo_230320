<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center">
	<div class="w-50 bg-info">
		<h1>글 목록</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
					<th>작성날짜</th>
					<th>수정날짜</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${postList}" var="post">
				<tr>
					<td>${post.id}</td>
					<td><a href="/post/post_detail_view?postId=${post.id}">${post.subject}</td>
					<td>${post.createdAt}
						<%-- ZonedDateTime --%>
						<fmt:parseDate value="${post.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="paredCreatedAt" />
						<fmt:formatDate value="${paredCreatedAt}" pattern="yyyy년 M월 d일 HH:mm:ss" />
					</td>
					<td>${post.updatedAt}
						<fmt:parseDate value="${post.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="paredCreatedAt" />
						<fmt:formatDate value="${paredCreatedAt}" pattern="yyyy년 M월 d일 HH:mm:ss" />
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="d-flex justify-content-end">
			<a href="/post/post_create_view" class="btn btn-warning">글쓰기</a>
		</div>
	</div>
</div>