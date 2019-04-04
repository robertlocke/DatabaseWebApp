<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Database</h1>

<table>
    <tr>
        <th>ID</th>
        <th>CREATETIME</th>
        <th>PERSISTTIME</th>
        <th>SITE</th>
        <th>CONFIG</th>
        <th>QUERY</th>
        <th>NUMROWS</th>
        <th>FETCH</th>
        <th>TOTAL</th>
        <th>EXECUTION</th>
        <th>INSTANCE</th>
        <th>OPEN</th>
        <th>COMMIT</th>
        <th>CLOSE</th>
        <th>SUPPORTMODE</th>
        <th>LOCALID</th>
        <th>SERVERID</th>
        <th>QUEUEID</th>
        <th>ALERTLEVEL</th>
        <th>ALERTMAX</th>
    </tr>

    <c:forEach var="result" items="${data}">
        <tr>
            <td>${result.id}</td>
            <td>${result.createTime}</td>
            <td>${result.persistTime}</td>
            <td>${result.site}</td>
            <td>${result.config}</td>
            <td>${result.query}</td>
            <td>${result.numrows}</td>
            <td>${result.fetch}</td>
            <td>${result.total}</td>
            <td>${result.execution}</td>
            <td>${result.instance}</td>
            <td>${result.open}</td>
            <td>${result.commit}</td>
            <td>${result.close}</td>
            <td>${result.supportmode}</td>
            <td>${result.localid}</td>
            <td>${result.serverid}</td>
            <td>${result.queueid}</td>
            <td>${result.alertlevel}</td>
            <td>${result.alertmax}</td>


        </tr>
    </c:forEach>
</table>

</body>
</html>
