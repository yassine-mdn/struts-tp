<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Spécialité</title>
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
        <th>Designation</th>
        <th>id Etudiants</th>
        <th>Actions</th>
    </tr>
    <s:iterator value="moduleList" status="moduleStatus">
        <tr>
            <td><s:property value="idM"/></td>
            <td><s:property value="designation"/></td>
            <td>
                <s:iterator value="etudiants">
                    <s:property value="idE"/>
                    <label> ; </label>
                </s:iterator>
            </td>
            <td><a type="button"
                   href="/user/updateProd.action?id=<s:property value="idS"/>">Edit</a>
                <a type="button" href="/deleteProd.action?id=<s:property value="idS"/>">Delete</a>
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
