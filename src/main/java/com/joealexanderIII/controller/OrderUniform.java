package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * The OrderUniform servlet will get all the players for the user and forward that data to the jsp.
 *
 * @author jalexander1
 * @version 1.0
 * @since 12/11/2019
 */
@WebServlet(
        name = "uniformOrder",
        urlPatterns = { "/orderUniform-servlet" }
)

public class OrderUniform extends HttpServlet {

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

        // Get the user data
        User loggedInUser = (User)userDao.getById((Integer)session.getAttribute("userID"));

        // Get the players for the user
        Set<Player> players = loggedInUser.getPlayers();

        // Set up select box information
        session.setAttribute("allPlayers", players);

        //Create the url
        String url = "uniformOrder.jsp";

        // Redirect to JSP page
        resp.sendRedirect(url);

    }

}