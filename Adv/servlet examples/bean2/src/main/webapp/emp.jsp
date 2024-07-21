
<html>

<body>
<jsp:useBean id="eb" class="bean2.EmpBean" />
<jsp:setProperty name="eb" property="*"/>
emp no: <jsp:getProperty name="eb" property="empno"/><br>
emp name: <jsp:getProperty name="eb" property="name"/><br>
emp sal: <jsp:getProperty name="eb" property="salary"/><br>
</body>
</html>