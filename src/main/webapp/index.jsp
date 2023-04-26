<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/user/test.action">Hello Servlet</a>

<div>
    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/etudiant/listerEtudiant.action">Lister les étudiants</a>
</div>
<div>
    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/etudiant/addEtudiant.action"> Ajouter étudiant</a>
</div>
<div>
    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/specialite/listerSpecialite.action">Lister les specialités</a>
</div>
<div>
    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/specialite/addSpecialite.action"> Ajouter une specialité</a>
</div>
<div>
    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/module/listerModule.action">Lister les modules</a>
</div>
<div>
    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/module/addModule.action"> Ajouter un module</a>
</div>

</body>
</html>