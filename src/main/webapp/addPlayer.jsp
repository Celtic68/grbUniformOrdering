<%-- The addPlayer jsp will create a form allowing the user to enter data
     for a player that will be added to the grb_player database.

 Author - jalexander1
 Version - 1.0
 Since - 10/11/2019

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Add Player" scope="session" />

<!doctype html>
<html>


<c:import url="head-tag.jsp" />

<body>
<div id="container">

    <c:import url="header.jsp" />

    <c:import url="menu.jsp" />

    <div id="body">

        <h3>${addPlayerMessage}</h3>

        <c:remove var="addPlayerMessage" />

        <form action="/com.joealexanderIII/addEditPlayer-servlet" method="POST">
            <fieldset>
                <legend>New Player Information</legend>
                <div class="form-group">
                    <label for="firstName">Player First Name:</label>
                    <input type="text" class="form-control" name="firstName" id="firstName" />
                </div>
                <div class="form-group">
                    <label for="lastName">Player Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" />
                </div>
                <div class="form-group">
                    <label for="siteLocation">Player Site Location:</label>
                    <select class="form-control" name="siteLocation" id="siteLocation" >
                        <c:forEach items="${locationCategory}" var="location">
                            <option value="${location.id}">${location.description}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="ageGroup">Player Age Group:</label>
                    <select class="form-control" name="ageGroup" id="ageGroup" >
                        <c:forEach items="${ageGroup}" var="age">
                            <option value="${age.description}">${age.description}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" name="submitButton" value="Create Player" />
                    <input type="reset" class="btn btn-secondary" name="clearButton" value="Clear" />
                </div>
            </fieldset>
        </form>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>

