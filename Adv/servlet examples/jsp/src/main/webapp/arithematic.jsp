
<html>

<body>
<h1>
<%-- <%@ page language=java import="java.lang.*" buffer="16kb" autoFlush=true errorPage="error.jsp" %>--%>
<%
String s=request.getParameter("operation");
if(s.equals("Addition")){
	%><jsp:forward page="add.jsp"/><%
}
else if(s.equals("Subraction")){
	%><jsp:forward page="sub.jsp"/><%
}
else if(s.equals("Multiplication")){
	%><jsp:forward page="mul.jsp"/><%
}
else{
	%><jsp:forward page="div.jsp"/><%
}

%>
</h1>
</body>
</html>