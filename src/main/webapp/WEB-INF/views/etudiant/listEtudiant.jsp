<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Students</title>
    <style>
        .center {
            margin-left: auto;
            margin-right: auto;
        }

        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>
<table class="center">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Moyenne</th>
        <th>Specialité</th>
        <th>Modules</th>
        <th>Actions</th>
    </tr>
    <s:iterator value="etudiantList" status="etudiantStatus">
        <tr>
            <td><s:property value="idE"/></td>
            <td><s:property value="nom"/></td>
            <td><s:property value="prenom"/></td>
            <td><s:property value="moyenne"/></td>
            <td><s:property value="specialite.designation"/></td>
            <td>
                <s:iterator value="modules">
                    <s:property value="designation"/>
                    <label> ; </label>
            </s:iterator>
            </td>
            <td><a type="button"
                   href="${pageContext.request.contextPath}/etudiant/updateEtudiant.action?idE=<s:property value="idE"/>">Edit</a>
                <a type="button" href="${pageContext.request.contextPath}/etudiant/deleteEtudiant.action?idE=<s:property value="idE"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
</table>

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
