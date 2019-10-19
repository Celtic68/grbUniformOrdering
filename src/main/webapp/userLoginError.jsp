<%-- The userLogin Error jsp is part of the Tomcat authentication routine and will be displayed
     when a user enters the wrong credentials.

 Author - jalexander1
 Version - 1.0
 Since - 10/19/2019

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Login Error" scope="session" />

<!doctype html>
<html>


<c:import url="head-tag.jsp" />

<body>
<div id="container">

    <c:import url="header.jsp" />

    <c:import url="menu.jsp" />

    <div id="body">

        <h3>Login Error</h3>

        <p>You have entered the wrong credentials - click <a href="userLogin.jsp">here</a> to try again.</p>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>

