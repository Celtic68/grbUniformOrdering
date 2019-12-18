package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.AgeGroup;
import com.joealexanderIII.model.Location;
import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The AddPlayer servlet will get the data used to build the select boxes on the Add Player form and
 * perform validation and add a player to the database.
 *
 * @author jalexander1
 * @version 1.0
 * @since 10/27/2019
 */
@WebServlet(
        name = "addPlayer",
        urlPatterns = { "/addPlayer-servlet" }
)


public class AddPlayer extends HttpServlet {

    Player player;

    // Define constants
    private static String firstName = "firstName";
    private static String lastName = "lastName";

    /**
     * Handles HTTP GET requests.
     *
     * @param req  Description of the Parameter
     * @param resp Description of the Parameter
     * @throws ServletException if there is an Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Instantiate a generic DAO for a Location
        GenericDao locationDao = new GenericDao(Location.class);

        // Instantiate a generic DAO for an Age Group
        GenericDao ageGroupDao = new GenericDao(AgeGroup.class);

        // Get a session
        HttpSession session = req.getSession();

        // Get all the location data
        List<Location> allLocations = (List<Location>) locationDao.getAll();

        // Get all the age group data
        List<AgeGroup> allAgeGroups = (List<AgeGroup>) ageGroupDao.getAll();

        // Set up select box information
        session.setAttribute("locationCategory", allLocations);
        session.setAttribute("ageGroup", allAgeGroups);

        //Create the url
        String url = "addPlayer.jsp";

        // Redirect to JSP page
        resp.sendRedirect(url);

    }

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
        String validationMessage;
        int insertedId;
        GenericDao userDao;
        GenericDao playerDao;
        String url;

        // Instantiate a new player
        player = new Player();

        // Get a session
        HttpSession session = request.getSession();

        // Validate the player data
        validationMessage = validatePlayerData(request);

        /* If all the validations passed, add the player to the database. If not,
            send the invalid responses.
        */
        if (validationMessage.length() == 0) {

            // Instantiate a generic User dao and get the user data
            userDao = new GenericDao(User.class);
            User loggedInUser = (User) userDao.getById((Integer) session.getAttribute("userID"));
            player.setUser(loggedInUser);

            // Instantiate a generic Player DAO
            playerDao = new GenericDao(Player.class);

            // Set the location and age group
            player.setPlayerSiteLocation((Integer.parseInt(request.getParameter("siteLocation"))));
            player.setPlayerAgeGroup(request.getParameter("ageGroup"));

            // Add the player to the database
            insertedId = playerDao.insert(player);

            // Set the validation message for adding a user to the session
            if (insertedId > 0) {
                session.setAttribute("addEditPlayerMessage",
                        "The player was added to the database");
            } else {
                session.setAttribute("addEditPlayerMessage", "The player was not added to the database");
            }
            url = "addEditPlayer-servlet";
        } else {
            session.setAttribute("addPlayerMessage", validationMessage);
            displayEnteredFormData(session, request);
            url = "addPlayer.jsp";
        }

        // Redirect to JSP page
        response.sendRedirect(url);

    }

    /**
     * The validatePlayerData method will validate each of the fields on the form and return a message
     * to the calling method with any invalid responses.
     *
     * @param request the request
     * @return a validation message
     */
    public String validatePlayerData(HttpServletRequest request) {

        // Define local variables
        String validationMessage = "";

        // Validate the player first name
        if (request.getParameter(firstName) == null
                || request.getParameter(firstName).trim() == "") {
            validationMessage += "The first name must be entered and not be all spaces<br />";

        } else {
            player.setPlayerFirstName(request.getParameter(firstName));
        }

        // Validate the player last name
        if (request.getParameter(lastName) == null
                || request.getParameter(lastName).trim() == "") {
            validationMessage += "The last name must be entered and not be all spaces<br />";
        } else {
            player.setPlayerLastName(request.getParameter(lastName));
        }

        return validationMessage;

    }

    /**
     * Display entered form data when an error occurs.
     *
     * @param session the session
     * @param request the request
     */
    public void displayEnteredFormData(HttpSession session, HttpServletRequest request) {

        session.setAttribute("firstNameValue", request.getParameter(firstName));
        session.setAttribute("lastNameValue", request.getParameter(lastName));
        session.setAttribute("locationValue", request.getParameter("siteLocation"));
        session.setAttribute("ageGroupValue", request.getParameter("ageGroup"));

    }

}