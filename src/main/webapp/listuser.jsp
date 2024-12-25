<jsp:include page = "include/header.jsp"/>
<%@page import= java.util.List  %>
<%@ page import = dev.anurag.entity.User %>

<h1>List Users</h1>
<table border="1">
<thead>
<th>UserId</th>
<th>Username</th>
<th>Email</th>
<th>Operation(s)</th>
</thead>
<%
List<User> listusers = (List)request.getAttribute("listuser");
for(User _users : listusers){
	out.println("<tr>");
	out.println("<td>" + _users.getUser_id() + "</td>");
	out.println("<td>" + _users.getUsername() + "</td>");
	out.println("<td>" + _users.getEmail() + "</td>");
	out.println("<td> <a href="+request.getContextPath()+"/Site?page=updateuser&userId="+_users.getUser_id()+"&username="+_users.getUsername()+"&emailId="+_users.getEmail()+">Update</a>");
	out.println(" | ");
	out.println("<a href="+request.getContextPath()+"/Site?page=deleteuser&userId="+_users.getUser_id()+">Delete</a></td>");
	out.println("</tr>");
}
%>
</table>
<jsp:include page = "include/footer.jsp"/>