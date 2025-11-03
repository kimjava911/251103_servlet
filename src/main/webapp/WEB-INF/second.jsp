<%-- directive <- 차후에 설명 --%>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  선언부 : 뒤에 나올 변수/메서드를 선언해야 되는 경우, 멤버변수나 메서드를 현재 jsp를 통해 만들어질 서블릿 클래스에 포함시킴 --%>
<%! Random rd = new Random(); %>
<%! void hello() {
    System.out.println("HELLO!");
} %>
<html>
<head>
    <title>.jsp로 못들어옴</title>
</head>
<body>
  <!-- HTML 주석 : HTML 문서에 일부 -->
  <%-- JSP 주석 : JAVA 코드로 취급이 되어서 최종적으로 삭제 --%>
  <h1>못 들어오지롱</h1>
  <%-- 스크립틀릿/스크립트릿 (scriptlet) --%>
  <% // 주석을 써도 된다
      System.out.println("반가워요~!"); // 일종의 서블릿이다
      // %>
  <% for (int i = 0; i < 10; i++) {%>
    <%--  response.getWriter().println(...)  --%>
<%--    <p>반복! 반복! 반복!</p>--%>
<%--    <p><% response.getWriter().println(i); %></p>--%>
    <%-- 변수나 값을 현재 위치에서 출력 --%>
    <%--  표현식(Expression) --%>
    <p><%= i %></p>
  <% } %>
  <%
//      Random rd = new Random();
      if (rd.nextBoolean()) { // true가 나오면...
          hello();
  %>
      <p>당첨!</p>
  <% } else { %>
      <p>탈락!</p>
  <% } %>
</body>
</html>
