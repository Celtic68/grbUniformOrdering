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

        <form action="editUser-servlet" method="POST">
            <fieldset>
                <legend>Edit User Information</legend>
                <div class="form-group">
                    <label for="firstName">User First Name:</label>
                    <input type="text" class="form-control" name="firstName" id="firstName"
                    value="${userData.userFirstName}"/>
                </div>
                <div class="form-group">
                    <label for="lastName">User Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName"
                    value="${userData.userLastName}"/>
                </div>
                <div class="form-group">
                    <label for="address1">User Address 1:</label>
                    <input type="text" name="address1" class="form-control" id="address1"
                    value="${userData.userAddress1}"/>
                </div>
                <div class="form-group">
                    <label for="address2">User Address 2:</label>
                    <input type="text" name="address2" class="form-control" id="address2"
                    value="${userData.userAddress2}"/>
                </div>
                <div class="form-group">
                    <label for="city">User City:</label>
                    <input type="text" name="city" id="city" class="form-control"
                    value="${userData.userCity}"/>
                </div>
                <div class="form-group">
                    <label for="state">User State:</label>
                    <input type="text" name="state" id="state" class="form-control"
                    value="${userData.userState}"/>
                </div>
                <div class="form-group">
                    <label for="zipCode">User Zip Code:</label>
                    <input type="text" name="zipCode" id="zipCode" class="form-control"
                    value="${userData.userZip}"/>
                </div>
                <div class="form-group">
                    <label for="phone">User Phone Number:</label>
                    <input type="number" name="phone" id="phone" class="form-control"
                    value="${userData.userPhone}"/>
                </div>
                <div class="form-group">
                    <label for="email">User Email address</label>
                    <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp"
                    value="${userData.userEmail}">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
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


