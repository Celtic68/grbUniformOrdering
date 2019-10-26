package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;

/**
 * The EditUser servlet will get the user data for the logged in user and pass that data to the
 * Edit Player jsp.
 *
 * @author jalexander1
 * @version 1.0
 * @since 10 /26/2019
 */
@WebServlet(
        name = "addEditPlayer",
        urlPatterns = { "/addEditPlayer-servlet" }
)

public class AddEditPlayer extends HttpServlet {

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

        // Instantiate a generic DAO for a User
        GenericDao genericDao = new GenericDao(User.class);

        // Get a session
        HttpSession session = req.getSession();

        // Get the user data
        User loggedInUser = (User)genericDao.getById((Integer)session.getAttribute("userID"));

        // Get the players for the user
        Set<Player> players = loggedInUser.getPlayers();

        // Check for no players and set message if no players are found otherwise pass the players to the jsp
        if (players.size() == 0) {
            session.setAttribute("addEditPlayerMessage", "No Players found for this account");
            session.setAttribute("playersFound", false);
        } else {
            session.setAttribute("playersFound", true);
            session.setAttribute("players", players);
        }

        //Create the url
        String url = "addEditPlayer.jsp";

        // Redirect to JSP page
        resp.sendRedirect(url);

//        // Forward to the Add / Edit player jsp
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/addEditPlayer.jsp");
//        dispatcher.forward(req, resp);

    }

}
