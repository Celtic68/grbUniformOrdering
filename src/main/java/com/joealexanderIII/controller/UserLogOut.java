package com.joealexanderIII.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "userLogOut",
        urlPatterns = { "/userLogOut-servlet" }
)

public class UserLogOut extends HttpServlet {

    // Define instance variables
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        // Log a signoff message
        logger.debug("User is signing off");

        // Get a session
        HttpSession session = request.getSession();

        // Log the user out and send them back to the home page
        session.invalidate();
        response.sendRedirect("index.jsp");

    }
}
