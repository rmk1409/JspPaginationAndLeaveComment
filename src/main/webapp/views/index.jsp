<%@ page import="java.util.List" %>
<%@ page import="models.Msg" %>
<%@ page import="models.DaoMsg" %><%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 10.09.2016
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    String strPageId = request.getParameter("pageId");
    strPageId = strPageId == null ? "1" : strPageId;
    int pageId = Integer.parseInt(strPageId);
    int amountMsg = 5;

    List<Msg> msgs = DaoMsg.getMsgs((pageId - 1) * amountMsg, amountMsg);

    out.print(String.format("<h4>Page # %d</h4><hr>", pageId));
    for (Msg msg : msgs) {
        out.print(String.format("<b>%s</b>: %s<br>", msg.getAuthor(), msg.getMsg()));
    }

    int rowAmount = DaoMsg.getRowCount();
    int linkAmount = rowAmount % amountMsg == 0 ? rowAmount / amountMsg : rowAmount / amountMsg + 1;

    out.print("<br>");
    for (int i = 0; i < linkAmount; i++) {
%>
<a href=/?pageId=<%=i + 1%>><%=i + 1%></a>
<%
    }
%>
<hr>
<form action="MsgServlet" method="post">
    Name: <br>
    <input maxlength="20" type="text" name="userName"><br>
    Msg: <br>
    <textarea maxlength="100" cols="30" rows="5" name="userMsg"></textarea><br>
    <input type="submit" name="Send">
</form>
</body>
</html>
