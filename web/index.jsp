<%@ page import="entity.ProviderEntity" %>
<%@ page import="service.ProviderService" %>
<%@ page import="java.util.List" %>


<%--
  Created by IntelliJ IDEA.
  User: avvyazovetskov
  Date: 30.08.2017
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All providers</title>
    <link rel="stylesheet" type="text/css" href="mystyle.css"/>

</head>
<body>
<div id="mystyle">
    <h1>All providers</h1>

    <table>

        <thead>
        <tr>
            <th>Provider name</th>
            <th>Currencies</th>
            <th>Countries</th>
        </tr>
        </thead>
        <tbody>
        <%
            ProviderService service = new ProviderService();
            List<ProviderEntity> providers = service.getAllProviders();
            for (ProviderEntity provider : providers) {%>
        <tr>
            <td><%=provider.getName()%></td>
            <td><%=provider.getCurrencies()%></td>
            <td><%=provider.getCountries()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
