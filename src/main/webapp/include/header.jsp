<!DOCTYPE html>
<head>
    <%
    if(request.getAttribute("title")==null){
    	out.print("<title>HomePage</title>");
    }else{
    	out.print("<title>" + request.getAttribute("title") + "</title>");
    }
    %>
    <link rel="stylesheet" href="assets/style2.css">
</head>
<body>
    <header id="head">
        <a id="name">amazon.in</a>
        <input id="input" placeholder="Search Amazon.in">
        <button id="butt">Search</button>
        <a href="<%=request.getContextPath()%>/Site?page=adduser">Add User</a>
        <a href="<%=request.getContextPath()%>/home?page=home">Home</a>
        <a href="<%=request.getContextPath()%>/Site?page=listuser">ListUser</a>
    </header>
    
    <br>
     <br>
      <br>
       <br>
    