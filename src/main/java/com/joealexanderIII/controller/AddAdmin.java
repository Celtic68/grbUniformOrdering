package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The AddAdmin servlet will get the user selected to add administrative rights and update their role on the database.
 *
 * @author jalexander1
 * @version 1.0
 * @since 12/18/2019
 */
@WebServlet(
        name = "addAdmin",
        urlPatterns = { "/addAdmin-servlet" }
)


public class AddAdmin extends HttpServlet {

    /**
     * Handles HTTP POST requests.
     *
     * @param request  Description of the Parameter
     * @param response Description of the Parameter
     * @throws IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        // Define local variables
        GenericDao userDao = new GenericDao(User.class);
        GenericDao roleDao = new GenericDao(Role.class);

        // Instantiate a new user and a new Role
        User user = new User();

        // Get a session
        HttpSession session = request.getSession();

        // Get the User Data
        user = (User)userDao.getById(((Integer.parseInt(request.getParameter("user")))));

        // Get the role for the specific user name
        Role userToUpdate = (Role)roleDao.getByPropertyUniqueEqual("userName", user.getUserName());

        // Update the users role
        userToUpdate.setUserRole("admin");
//        userToUpdate.setUser(user);

        // Save the change to the database
        roleDao.saveOrUpdate(userToUpdate);

        // Update the users list used to create the dropdown
        List<User> allUsers = (List<User>) session.getAttribute("allUsers");
        allUsers.remove(user);
        session.setAttribute("allUsers", allUsers);
        
        // Set the validation message for adding an admin user to the session
        session.setAttribute("addAdminMessage",
                "The user has been given Admin rights");

        // Format the forwarding url
        String url = "addAdminUser.jsp";

        // Redirect to JSP page
        response.sendRedirect(url);

    }

}
