<jsp:include page = "include/header.jsp"/>

<form action = "<%=request.getContextPath()%>/Site" method="post">
<b style="color:Black;">User name</b> : <input type="text" name="Username" value="${param.username}"required="required"><br>
<b style="color:Black;">Email</b>: <input type="email" name="email" value="${param.emailId}"required="required"></br>
        <input type="hidden" name="form" value="updateUserOperation"></br>
        <input type="hidden" name="user_id" value="${param.userId}"></br>
        <input type="submit" value="Update User">
</form>
<jsp:include page = "include/footer.jsp"/>

