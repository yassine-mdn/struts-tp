<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
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
    <s:form action="addSpecialite.action">
        <s:textfield name="specialite.designation" label="Designation"/>
        <s:submit value="Add Specialite" />
    </s:form>
</div>

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
