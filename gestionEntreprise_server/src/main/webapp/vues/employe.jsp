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
<br><br>
<form method=get action=Employemc>
<div class=container>
<div class="row mt-4 pl-2">
<div class="col-md-1">
<label for="mc" class="form-label">Mot Cle:</label>
</div>
<div class="col-md-3">
<input type="text" id="mc" class="form-control" name=mc>
</div>
<div class="col-md-3">
<button type="submit" class="btn btn-primary">Chercher</button>
</div> </div> </div> </form>
<br><hr>
<h2 style="text-align: center;">Liste des employ?s</h2>
<table class="table table-hover">

<tr><th>Id</th><th>NOM</th><th>PRENOM</th><th>E-MAIL</th><th>Contrat</th><th>Action</th>
</tr>
<c:forEach items="${liste}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.prenom}</td>
<td>${p.nom }</td>
<td>${p.email}</td>
<td>${p.contrat.typeContrat}</td>
<td><a href="/Entreprise/supprimerEmploye/${p.id}"
 class="btn btn-danger">supprimer</a>
  <a href="/Entreprise/modifierEmploye/${p.id}" class="btn btn-warning">
 Edit</a></td>
 
 

</tr>
</c:forEach>
</table>
</body>
</html>