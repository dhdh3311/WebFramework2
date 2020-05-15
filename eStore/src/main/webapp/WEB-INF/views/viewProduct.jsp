<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="view-product-wrapper">
	<div class="row">
		<div class="col-md-6">
			<div class="product-img">
				<c:set var="imageFilename"
					value="/resources/images/${product.id}.jpg" />
			</div>
			<img src="<c:url value="${imageFilename}" />" alt="image"
				style="width: 80%" />
			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p>
					<strong> Description: </strong> ${product.description}
				</p>

			</div>
		</div>
	</div>
</div>