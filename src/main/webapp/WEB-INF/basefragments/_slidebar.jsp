<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-3" style ="border-left:1px solid black; padding-left: 30px;">
	<address>
		<!-- lastest news -->
		<div class="lastest-news">
			
			<div class="main-title row">
				<strong>Tin tức nổi bật </strong> <a href="lastestnews.html"><img
					class="edit-more" src="img/arrow-right.png" alt="no-image" /></a>
			</div>
			<c:forEach items="${hotlist }" var ="item">
			<div class=" main-alink row">
				<a href="/article?id=${item.id }"><img src="img/icon/bullet.png" alt="No image"/> ${item.title }</a>
			</div>
			</c:forEach>
		</div>
		<!-- end class .lastest news -->

		<!-- important deadlines -->
		<div class="important-deadlines">
			<div class="main-title row">
				<strong>Tin tức gần đây </strong> <a href="#"><img
					class="edit-more" src="img/arrow-right.png" alt="no-image" /></a>
			</div>
			<c:forEach items="${recentlist }" var ="item">
			<div class="row">
					<a href="/article?id=${item.id }">${item.title }</a>
					<hr />
			</div>
			</c:forEach>
		</div>
		<!-- end class important deadlines -->

		<!-- class special-session -->
		<div class="special-session">
			<div class="main-title row">
				<strong>Mùa đặc biệt </strong> <a href="#"><img
					class="edit-more" src="img/arrow-right.png" alt="no-image" /></a>
			</div>
		</div>
		<div class="row">
			<div class="link-session">
				<mark>SPECIAL SESSION 01 INTELLIGENT HEALTHCARE SYSTEMS</mark>
				<br /> <a href="#">CALL FOR PAPERS</a>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="link-session">
				<mark>SPECIAL SESSION 01 INTELLIGENT HEALTHCARE SYSTEMS</mark>
				<br /> <a href="#">CALL FOR PAPERS</a>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="link-session">
				<mark>SPECIAL SESSION 01 INTELLIGENT HEALTHCARE SYSTEMS</mark>
				<br /> <a href="#">CALL FOR PAPERS</a>
				<hr />
			</div>
		</div>
		<!-- end class special-session -->

		<div class="key-links">
			<div class="main-title row">
				<strong>Liên kết website </strong> <a href="#"><img
					class="edit-more" src="img/arrow-right.png" alt="no-image" /></a>
			</div>
			<div class="row">
				<div class="alink-key">
					<a href="#">EASYCHAIR SUBMISSION SITE</a>
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="alink-key">
					<a href="#">PAPER FORMAT TEMPLATE DOWNLOAD </a>
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="alink-key">
					<a href="#">EASYCHAIR SUBMISSION INSTRUCTION</a>
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="alink-key">
					<a href="#">INSTRUCTION FOR REVIEWER</a>
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="alink-key">
					<a href="#">THE IEEE COPYRIGHT FORM</a>
					<hr />
				</div>
			</div>
		</div>
	</address>
</div>