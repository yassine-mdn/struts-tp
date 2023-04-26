<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yassi
  Date: 4/26/2023
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete Etudiant</title>
    <style>
        .center {
            margin: auto;
            width: 50%;
            border: 3px solid black;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="center">
    <h1> etudiant avec id = <s:property value="idE"/> supprimer</h1>
    <div>
        <a type="button" class="btn btn-success"
           href="${pageContext.request.contextPath}/etudiant/listerEtudiant.action">Lister les étudiants</a>
    </div>
    <div>
        <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/etudiant/addEtudiant.action">
            Ajouter étudiant</a>
    </div>
    <div>
        <a type="button" class="btn btn-success"
           href="${pageContext.request.contextPath}/specialite/listerSpecialite.action">Lister les specialités</a>
    </div>
    <div>
        <a type="button" class="btn btn-success"
           href="${pageContext.request.contextPath}/specialite/addSpecialite.action"> Ajouter une specialité</a>
    </div>
    <div>
        <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/module/listerModule.action">Lister
            les modules</a>
    </div>
    <div>
        <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/module/addModule.action">
            Ajouter un module</a>
    </div>
</div>
</body>
</html>
