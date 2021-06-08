<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2021
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${categoryList}" var="category">
                <li class="list-group-item text-white ${tag == category.cId ? "active":""}"><a href="category?cid=${category.cId}">${category.cName}</a></li>
            </c:forEach>


        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${lastProduct.image}" />
            <h5 class="card-title">${lastProduct.name}</h5>
            <p class="card-text">${lastProduct.title}</p>
            <p class="bloc_left_price">${lastProduct.price} $</p>
        </div>
    </div>
</div>