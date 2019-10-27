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
import java.util.Set;

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

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req                   Description of the Parameter
     *@param  resp                  Description of the Parameter
     *@exception ServletException   if there is an Servlet failure
     *@exception IOException        if there is an IO failure
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instantiate a generic DAO for a Location
        GenericDao locationDao = new GenericDao(Location.class);

        // Instantiate a generic DAO for an Age Group
        GenericDao ageGroupDao = new GenericDao(AgeGroup.class);

        // Get a session
        HttpSession session = req.getSession();

        // Get all the location data
        List<Location> allLocations = (List<Location>)locationDao.getAll();

        // Get all the age group data
        List<AgeGroup> allAgeGroups = (List<AgeGroup>)ageGroupDao.getAll();

        // Set up select box information
        session.setAttribute("locationCategory", allLocations);
        session.setAttribute("ageGroup", allAgeGroups);

        //Create the url
        String url = "addPlayer.jsp";

        // Redirect to JSP page
        resp.sendRedirect(url);

    }
}
