
<html>

<body>

<jsp:useBean id="mb" class="bean.MessageBean"/>
<jsp:setProperty name="mb" property="message" value="Welcome"/>
<!-- when there are multiple setter methods we can use * for property, so all properties will be stored, example in day bean2-->
<jsp:getProperty name="mb" property="message"/>

</body>
</html>