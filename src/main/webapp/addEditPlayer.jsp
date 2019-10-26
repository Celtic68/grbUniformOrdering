<%-- The addEditPlayer jsp will display all existing players to allow them to be edited as well as an Add Player link.

 Author - jalexander1
 Version - 1.0
 Since - 10/26/2019

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Add/Edit Player" scope="session" />

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

        <h3 id="playersHeader">Players</h3>

        <table class="table table-dark" id="playerTable">
            <thead class="thead-dark"></thead>
            <tr>
                <th scope="col">Player</th>
                <th scope="col">Age Group</th>
                <th scope="col">Location</th>
                <th scope="col">Action</th>
            </tr>
            <tbody>

        <c:choose>

            <c:when test="${!playersFound}" >
                <tr>
                    <td scope="row" colspan="4" style="align-content: center; font-size: 32px;">${addEditPlayerMessage}</td>
                </tr>
            </c:when>

            <c:otherwise>

                <c:forEach var="player" items="${players}">
                    <tr scope="row">
                        <td>${player.playerFirstName} ${player.playerLastName}</td>
                        <td>${player.playerAgeGroup}</td>
                        <td>${player.playerSiteLocation}</td>
                        <td><a href="editPlayer-servlet?player=${player}"><span class="fas fa-edit"></span></a></td>
                    </tr>
                </c:forEach>

            </c:otherwise>

        </c:choose>

            </tbody>

        </table>

        <c:remove var="addEditPlayerMessage" />

        <div>
            <form action="addPlayer.jsp">
                <div class="form-group">
                    <button type="submit" id="newPlayerAddButton" class="btn btn-primary">Add a New Player</button>
                </div>
            </form>
        </div>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
