package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.Role;
import com.joealexanderIII.model.User;
import org.apache.catalina.realm.MessageDigestCredentialHandler;
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
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * The EditUser servlet will get the user data for the logged in user and pass that data to the
 * Edit Player jsp.
 *
 * @author jalexander1
 * @version 1.0
 * @since 10/26/2019
 */
@WebServlet(
        name = "editUser",
        urlPatterns = { "/editUser-servlet" }
)

public class EditUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instantiate a generic DAO
        GenericDao genericDao = new GenericDao(User.class);

        // Get a session
        HttpSession session = req.getSession();

        // Retrieve the ID from the session
        Integer userId = (Integer)session.getAttribute("userID");

        // Get the user data
        User loggedInUser = (User)genericDao.getById(userId);

        // Display the user data to the page
        displayUserData(session, loggedInUser);

        // Forward to the Edit User jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editUser.jsp");
        dispatcher.forward(req, resp);

    }

    public void displayUserData(HttpSession session, User loggedInUser) {

        session.setAttribute("userData", loggedInUser);

    }

}
