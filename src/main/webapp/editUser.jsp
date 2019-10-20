<%-- The editUser jsp will create a form allowing the user to edit the user
     profile to update the grb_user database.

 Author - jalexander1
 Version - 1.0
 Since - 10/11/2019

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Edit User" scope="session" />

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

        <h3>${userEditMessage}</h3>

        <c:remove var="userEditMessage" />

        <form action="/com.joealexanderIII/userEdit-servlet" method="POST">
            <fieldset>
                <legend>Edit User Information</legend>
                <div class="form-group">
                    <label for="firstName">User First Name:</label>
                    <input type="text" class="form-control" name="firstName" id="firstName"
                    value="${userData.firstName}"/>
                </div>
                <div class="form-group">
                    <label for="lastName">User Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName"
                    value="${userData.lastName}"/>
                </div>
                <div class="form-group">
                    <label for="address1">User Address 1:</label>
                    <input type="text" name="address1" class="form-control" id="address1"
                    value="${userData.address1}"/>
                </div>
                <div class="form-group">
                    <label for="address2">User Address 2:</label>
                    <input type="text" name="address2" class="form-control" id="address2"
                    value="${userData.address2}"/>
                </div>
                <div class="form-group">
                    <label for="city">User City:</label>
                    <input type="text" name="city" id="city" class="form-control"
                    value="${userData.city}"/>
                </div>
                <div class="form-group">
                    <label for="state">User State:</label>
                    <input type="text" name="state" id="state" class="form-control"
                    value="${userData.state}"/>
                </div>
                <div class="form-group">
                    <label for="zipCode">User Zip Code:</label>
                    <input type="text" name="zipCode" id="zipCode" class="form-control"
                    value="${userData.zipCode}"/>
                </div>
                <div class="form-group">
                    <label for="phone">User Phone Number:</label>
                    <input type="text" name="phone" id="phone" class="form-control"
                    value="${userData.phone}"/>
                </div>
                <div class="form-group">
                    <label for="email">User Email address</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp"
                    value="${userData.email}">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="userPassword">User Password:</label>
                    <input type="password" name="userPassword" id="UserPassword" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="confirmUserPassword">Confirm User Password:</label>
                    <input type="password" name="confirmUserPassword" id="confirmUserPassword" class="form-control" />
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" name="submitButton" value="Update User" />
                </div>
            </fieldset>
        </form>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>


