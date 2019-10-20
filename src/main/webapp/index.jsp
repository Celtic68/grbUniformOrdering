<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>

<c:set var="pageTitle" value="GRB Academy Uniform Ordering" scope="session"  />
<c:import url="head-tag.jsp" />

<body>
<div id="container">

    <c:import url="header.jsp" />

    <c:choose>

        <c:when test="${pageContext.request.isUserInRole('admin')}" >
            <c:import url="/admin/adminMenu.jsp" />
        </c:when>

        <c:when test="${pageContext.request.isUserInRole('user')}" >
            <c:import url="/user/userMenu.jsp" />
        </c:when>

        <c:otherwise>
            <c:import url="menu.jsp" />
        </c:otherwise>

    </c:choose>

    <div id="body">

        <section id="homePageContent">

            <article>

                <img src="images/RaysPlayer1.jpg" id="homePagePlayer" alt="One of our hitters getting after it!">

                <h2>Welcome to the GRB Rays Uniform Ordering Site!</h2>

                <p>In order to better serve our families, we have created this site to help our Winter Meeting go
                    smoother. All you need to do is create an account and add your son as a player to allow you to
                    order his uniform electronically!</p>

                <p>Once everyone has had a chance to order their uniforms, an email confirmation will be sent to all
                   members. If you need to modify your order, just sign back in and make any changes necessary.</p>

                <p>It's just that easy - sign up and order today!</p>

            </article>

        </section>

        <div class="clear"></div>
    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
