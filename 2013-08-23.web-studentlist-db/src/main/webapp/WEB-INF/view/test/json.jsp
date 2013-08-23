<%@ page import="org.codehaus.jackson.map.ObjectMapper"%><%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%
   ObjectMapper mapper = new ObjectMapper();
   String json = mapper.writeValueAsString(request.getAttribute("students"));
%>
<%=json %>

