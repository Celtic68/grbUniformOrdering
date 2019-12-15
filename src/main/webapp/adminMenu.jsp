<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="index.jsp">GRB Uniform Ordering</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navb" class="navbar-collapse collapse hide">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="retrieveAllUsers-servlet?callingAction=addAdminLink">Add Admin</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="retrieveAllUsers-servlet?callingAction=editUserLink">Edit User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="retrieveAllUsers-servlet?callingAction=addPlayerLink">Add/Edit Player</a>
            </li>
        </ul>

        <ul class="nav navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="userLogOut-servlet"><span class="fas fa-sign-out-alt"></span> LogOut</a>
            </li>
        </ul>
    </div>
</nav>
