<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>제 첫 JSP 에요</title>
</head>
<body>
    <h1>첫 JSP임다</h1>
    <p>예쁘게 봐주세요</p>
    <p>
        <% response.getWriter().println(request.getAttribute("name")); %>
    </p>
</body>
</html>
