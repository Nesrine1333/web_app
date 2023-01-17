<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<%@include file="navbar.html" %>
<br>
<br>
<c:if test="${message!= null}">
<div class="alert alert-success" role="alert">
<c:out value="${message }"></c:out>
      ${Mission=null }
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header"><h2>Ajouter Mission</h2></div>
<div class="card-body">
<form action="/Entreprise/saveMission" method=post enctype="multipart/form-data">
 
 <div class="mb-3 mt-3">
 <label for="name" class="form-label">Nom:</label>
 <input type=text class="form-control" id="name" name="name" value="${Mission.name}">
 </div>
 
 <div class="mb-3">
 <label for="description" class="form-label">description:</label>
<input type=text class="form-control" id="description" name="description" value="${Mission.description}">
 </div>
 
  	
	
 
 <div class="mb-3">
 <label for="departements" class="form-label">Departement:</label>
 <select name="departements" >
 <option selected hidden>Choose here</option>
 <c:forEach items="${Departement}" var="cc">
 <option value=${cc.id} <c:if test="${Mission.departement.id==cc.id}">selected="true"</c:if>>${cc.name} </option>
 </c:forEach>
 </select>
 </div>
 
 

  <input type=hidden name=id value="${Mission.id}">
 <button type="submit" class="btn btn-primary" >Save</button>
</form></div> </div></div></body>
</html>