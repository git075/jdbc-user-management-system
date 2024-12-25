<jsp:include page = "include/header.jsp"/>

<form action = "<%=request.getContextPath()%>/Site" method="post">
<b style="color:Black;">User name</b> : <input type="text" name="Username" required="required"><br>
<b style="color:Black;">Email</b>: <input type="email" name="email" required="required"></br>
        <input type="hidden" name="form" value="addUserOperation"></br>
        <input type="submit" value="Add User">
</form>

<jsp:include page = "include/footer.jsp"/>

