<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="col-md-9">
	<div class="main-title row">
		<strong>Danh sách tin tức mới nhất</strong>
	</div>
	
	<c:forEach items="${articles }" var="item">
		<a href="/article?id=${item.id }">
		<div class="list-news row">
			<img class="img-circle col-md-3" src="${item.img }"
				alt="No-image">
			<h3 class="col-md-9">${item.title }</h3>
			<h5 class="col-md-9">${item.shortDescription }</h5>
			<h5 class="col-md-3 news-date">Ngày đăng : <fmt:formatDate value="${item.dateCreated}" pattern="dd-MM-yyyy HH:mm" /> </h5>
			<hr />
		</div>
		</a>
	</c:forEach>

</div>