<%-- The userSignUp jsp will create a form allowing the user to enter data
     to be added to the grb_user database.

 Author - jalexander1
 Version - 1.0
 Since - 10/09/2019

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Sign Up" scope="session" />

<!doctype html>
<html>


<c:import url="head-tag.jsp" />

<body>
<div id="container">

    <c:import url="header.jsp" />

    <c:import url="menu.jsp" />

    <div id="body">

        <h3>${userSignUpMessage}</h3>

        <c:remove var="userSignUpMessage" />

        <form action="userSignUp-servlet" method="POST">
            <fieldset>
                <legend>User Sign Up Information</legend>
                <div class="form-group">
                    <label for="firstName">User First Name:</label>
                    <input type="text" class="form-control" name="firstName" id="firstName" value="${firstNameValue}"/>
                </div>
                <div class="form-group">
                    <label for="lastName">User Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" value="${lastNameValue}" />
                </div>
                <div class="form-group">
                    <label for="address1">User Address 1:</label>
                    <input type="text" name="address1" class="form-control" id="address1" value="${address1Value}" />
                </div>
                <div class="form-group">
                    <label for="address2">User Address 2:</label>
                    <input type="text" name="address2" class="form-control" id="address2" value="${address2Value}" />
                </div>
                <div class="form-group">
                    <label for="city">User City:</label>
                    <input type="text" name="city" id="city" class="form-control" value="${cityValue}" />
                </div>
                <div class="form-group">
                    <label for="state">User State:</label>
                    <input type="text" name="state" id="state" class="form-control"
                           placeholder="Two character state abbreviation" value="${stateValue}" />
                </div>
                <div class="form-group">
                    <label for="zipCode">User Zip Code:</label>
                    <input type="text" name="zipCode" id="zipCode" class="form-control" value="${zipCodeValue}" />
                </div>
                <div class="form-group">
                    <label for="phone">User Phone Number:</label>
                    <input type="number" name="phone" id="phone" class="form-control" value="${phoneValue}" />
                </div>
                <div class="form-group">
                    <label for="email">User Email address</label>
                    <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp"
                           value="${emailValue}" >
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="userName">User Name:</label>
                    <input type="text" name="userName" id="userName" class="form-control" value="${userNameValue}" />
                </div>
                <div class="form-group">
                    <label for="userPassword">User Password:</label>
                    <input type="password" name="userPassword" id="userPassword" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="confirmUserPassword">Confirm User Password:</label>
                    <input type="password" name="confirmUserPassword" id="confirmUserPassword" class="form-control" />
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" name="submitButton" value="Create Account" />
                    <input type="reset" class="btn btn-secondary" name="clearButton" value="Clear" />
                </div>
            </fieldset>
        </form>

        <c:remove var="firstNameValue" />
        <c:remove var="lastNameValue" />
        <c:remove var="address1Value" />
        <c:remove var="address2Value" />
        <c:remove var="cityValue" />
        <c:remove var="stateValue" />
        <c:remove var="zipCodeValue" />
        <c:remove var="phoneValue" />
        <c:remove var="emailValue" />
        <c:remove var="userNameValue" />

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>

