package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.AgeGroup;
import com.joealexanderIII.model.Location;
import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The RetrieveAllUsers servlet will get the data used to build the select boxes on various forms.
 *
 * @author jalexander1
 * @version 1.0
 * @since 12/15/2019
 */
@WebServlet(
        name = "retrieveAllUsers",
        urlPatterns = { "/retrieveAllUsers-servlet" }
)


public class RetrieveAllUsers extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *
     * @param req  Description of the Parameter
     * @param resp Description of the Parameter
     * @throws ServletException if there is an Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Instantiate a generic DAO for a User
        GenericDao userDao = new GenericDao(User.class);

        // Get a session
        HttpSession session = req.getSession();

        // Get all the location data
        List<User> allUsers = (List<User>) userDao.getAll();

        // Set up select box information
        session.setAttribute("allUsers", allUsers);

        // Get the calling parameter to determine where this servlet was called from
        String callingLocation = req.getParameter("callingAction");

        //Create the url
        String url = "";
        if (callingLocation.equals("addAdminLink")) {
            url = "addAdminUser.jsp";
        } else if (callingLocation.equals("editUserLink")) {
            url = "editUserAsAdmin.jsp";
        } else if (callingLocation.equals("addPlayerLink")) {
            url = "addPlayerAsAdmin.jsp";
        }

        // Redirect to JSP page
        resp.sendRedirect(url);

    }

}
