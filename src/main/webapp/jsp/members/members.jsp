<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.MemberRepository" %>
<%@ page import="com.example.demo.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody><%
        for (Member member : members) {
            out.write("    <tr>");
            out.write("<td > " + member.getId() + " </td > ");
            out.write("                    < td > " + member.getUsername() + " </td > ");
            out.write("                    < td > " + member.getAge() + " </td > ");
            out.write("    </tr>");

        } %>
    </tbody>
</table>
</body>
</html>

<%--jsp 의 경우 html 을 간편하게 작성은 가능하지만 상단에 java 코드가 모두 노출되는 단점이 있으며--%>
<%--모든것을 jsp 가 담당하여 유지보수가 어렵다.--%>
