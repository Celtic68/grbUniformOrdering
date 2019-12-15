<%-- The addEdirUniformOrder jsp will create a form allowing the user to place a uniform order
     for a player that will be added to the grb_uniform_order database.

 Author - jalexander1
 Version - 1.0
 Since - 11/30/2019

--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Add Admin User" scope="session" />

<!doctype html>
<html>


<c:import url="head-tag.jsp" />

<body>
<div id="container">

    <c:import url="header.jsp" />

    <c:choose>

        <c:when test="${pageContext.request.isUserInRole('admin')}" >
            <c:import url="/adminMenu.jsp" />
        </c:when>

        <c:when test="${pageContext.request.isUserInRole('user')}" >
            <c:import url="/userMenu.jsp" />
        </c:when>

        <c:otherwise>
            <c:import url="menu.jsp" />
        </c:otherwise>

    </c:choose>

    <div id="body">

        <form action="orderUniform-servlet" method="POST">
            <fieldset>
                <legend>Choose the user for which to give admin rights</legend>
                <div class="form-group">
                    <label for="user">User:</label>
                    <select class="form-control" name="user" id="user" >
                        <c:forEach items="${allUsers}" var="user">
                            <option value="${user.id}">${user.userFirstName} ${user.userLastName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" name="submitButton" value="Select User" />
                </div>
            </fieldset>
        </form>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
