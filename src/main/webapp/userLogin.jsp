<%-- The userLogin jsp will use the Tomcat authentication routine to allow a user
     to enter their credentials and attempt to log in..

 Author - jalexander1
 Version - 1.0
 Since - 10/19/2019

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Login" scope="session" />

<!doctype html>
<html>


<c:import url="head-tag.jsp" />

<body>
<div id="container">

    <c:import url="header.jsp" />

    <c:import url="menu.jsp" />

    <div id="body">

        <h3>${userLoginMessage}</h3>

        <c:remove var="userLoginMessage" />

        <form action="j_security_check" METHOD="POST">
            <fieldset>
                <legend>User Log In Information</legend>
                <div class="form-group">
                    <label for="userName">User Name:</label>
                    <input type="text" class="form-control" name="j_username" id="userName" />
                </div>
                <div class="form-group">
                    <label for="password">User Password:</label>
                    <input type="password" class="form-control" name="j_password" id="password" />
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" name="submitButton" value="Log In" />
                    <input type="reset" class="btn btn-secondary" name="clearButton" value="Clear" />
                </div>
            </fieldset>
        </form>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>


