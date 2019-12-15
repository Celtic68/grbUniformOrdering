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

        // Get a session
        HttpSession session = request.getSession();

        // Get all the dropdown data
        getAllLocations(session);

        // Instantiate a new player
        Player player = new Player();

        //Create the url
        String url = "addEditUniformOrder.jsp";

        // Redirect to JSP page
        response.sendRedirect(url);

    }

    private void getAllLocations(HttpSession session) {

        // Instantiate a generic DAO for a Location
        GenericDao locationDao = new GenericDao(Location.class);

        List<Location> allLocations = (List<Location>) locationDao.getAll();

        // Set up select box information
        session.setAttribute("allLocations", allLocations);

    }

    private void getAllAgeGroups(HttpSession session) {

        // Instantiate a generic DAO for an Age Group
        GenericDao ageGroupDao = new GenericDao(AgeGroup.class);

        List<AgeGroup> allAgeGroups = (List<AgeGroup>) ageGroupDao.getAll();

        // Set up select box information
        session.setAttribute("allAgeGroups", allAgeGroups);

    }

    private void getAllHatSizes(HttpSession session) {

        // Instantiate a generic DAO for a Hat Size
        GenericDao hatSizeDao = new GenericDao(HatSize.class);

        List<HatSize> allHatSizes = (List<HatSize>) hatSizeDao.getAll();

        // Set up select box information
        session.setAttribute("allHatSizes", allHatSizes);

    }

    private void getAllJerseySizes(HttpSession session) {

        // Instantiate a generic DAO for a jersey size
        GenericDao jerseySizeDao = new GenericDao(JerseySize.class);

        List<JerseySize> allJerseySizes = (List<JerseySize>) jerseySizeDao.getAll();

        // Set up select box information
        session.setAttribute("allJerseySizes", allJerseySizes);

    }

    private void getAllPantsSizes(HttpSession session) {

        // Instantiate a generic DAO for a Pants Size
        GenericDao pantsSizeDao = new GenericDao(PantsSize.class);

        List<PantsSize> allPantsSizes = (List<PantsSize>) pantsSizeDao.getAll();

        // Set up select box information
        session.setAttribute("allPantsSizes", allPantsSizes);

    }

    private void getAllPantsStyles(HttpSession session) {

        // Instantiate a generic DAO for a Pants Style
        GenericDao pantsStyleDao = new GenericDao(PantsStyle.class);

        List<PantsStyle> allPantsStyles = (List<PantsStyle>) pantsStyleDao.getAll();

        // Set up select box information
        session.setAttribute("allPantsStyles", allPantsStyles);

    }



}