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
      ${models=null }
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header t"><h2>Ajouter Contrat</h2></div>
<div class="card-body">
<form action="/Entreprise/saveContrat" method=post enctype="multipart/form-data">
 
 <div class="mb-3 mt-3">
 <label for="typeContrat" class="form-label">typeContrat:</label>
 <input type=text class="form-control" id="typeContrat" name="typeContrat" value="${Contrat.typeContrat}">
 </div>
  <div class="mb-3 mt-3">
 <label for="salaire" class="form-label">salaire:</label>
 <input type=number class="form-control" id="salaire" name="salaire" value="${Contrat.salaire}">
 
 
 
 
 
 	<div class="mb-3">
 <label for="employes" class="form-label">Employe:</label>
 <select name="employes" >
 <option selected hidden>Choose here</option>
 <c:forEach items="${Employe}" var="cc">
 <option value=${cc.id} <c:if test="${Contrat.employe.id==cc.id}">selected="true"</c:if>>${cc.nom} </option>
 </c:forEach>
 </select>
 </div>
 
 
 
 
 
 
 <input type=hidden name=id value="${Contrat.reference}">
 
 <button type="submit" class="btn btn-primary" >Save</button>
</form></div> </div></div></body>
</html>
