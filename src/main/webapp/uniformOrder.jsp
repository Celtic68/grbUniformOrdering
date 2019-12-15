<%-- The addEdirUniformOrder jsp will create a form allowing the user to place a uniform order
     for a player that will be added to the grb_uniform_order database.

 Author - jalexander1
 Version - 1.0
 Since - 11/30/2019

--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Select Player for Uniform Order" scope="session" />

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
                <legend>Choose the player for which to place an order</legend>
                <div class="form-group">
                    <label for="player">Player:</label>
                    <select class="form-control" name="player" id="player" >
                        <c:forEach items="${allPlayers}" var="player">
                            <option value="${player.id}">${player.playerFirstName} ${player.playerLastName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" name="submitButton" value="Select Player" />
                </div>
            </fieldset>
        </form>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
