package com.joealexanderIII.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * A simple servlet whose purpose is to redirect to the home page
 * after a log in attempt
 *
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/loginAction"}
)

public class UserLoginAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req                   Description of the Parameter
     *@param  resp                  Description of the Parameter
     *@exception ServletException   if there is an Servlet failure
     *@exception IOException        if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get a session
        HttpSession session = req.getSession();

        // Log a user message for the user name and role
        logger.info("The logged in user is " + req.getRemoteUser());
        if (req.isUserInRole("admin")) {
            logger.info("The logged in credential is an admin");
        } else {
            logger.info("The logged in credential is a user");
        }

        // Instantiate a generic DAO
        GenericDao genericDao = new GenericDao(User.class);

        // Get the user data
        User loggedInUser = (User)genericDao.getByPropertyUniqueEqual("userName", req.getRemoteUser());

        // Set the user ID in session
        session.setAttribute("userID", loggedInUser.getId());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}
