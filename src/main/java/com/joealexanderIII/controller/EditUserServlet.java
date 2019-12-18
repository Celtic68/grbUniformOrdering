package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * The EditUser servlet will get the user data for the logged in user and pass that data to the
 * Edit Player jsp.
 *
 * @author jalexander1
 * @version 1.0
 * @since 10 /26/2019
 */
@WebServlet(
        name = "editUser",
        urlPatterns = { "/editUser-servlet" }
)

public class EditUserServlet extends HttpServlet {

    /**
     * The User.
     */
    // Define instance variables
    User user;

    // Define constants
    private static String zipCode = "zipCode";
    private static String phone = "phone";
    private static String email = "email";

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

        // Instantiate a generic DAO
        GenericDao genericDao = new GenericDao(User.class);

        // Get a session
        HttpSession session = req.getSession();

        // Get the user data
        getUserData(session, genericDao);

        // Display the user data to the page
        displayUserData(session);

        //Create the url
        String url = "editUser.jsp";

        // Redirect to JSP page
        resp.sendRedirect(url);

//        // Forward to the Edit User jsp
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/editUser.jsp");
//        dispatcher.forward(req, resp);

    }

    /**
     *  Handles HTTP POST requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        // Define local variables
        String validationMessage;

        // Instantiate a generic DAO
        GenericDao genericDao = new GenericDao(User.class);

        // Get a session
        HttpSession session = request.getSession();

        // Get the current user data
        getUserData(session, genericDao);

        /* Update the user object with the entered data. If the edits do not pass, display the
           error messages and the current user data   */
        updateUser(request);

        // Validate the user data
        validationMessage = validateUserData(request);

        /* If all the validations passed, update the user. If not,
            send the invalid responses.
        */
        if (validationMessage.length() == 0) {

            // Add the user to the database
            genericDao.saveOrUpdate(user);

            // Update the user data to the jsp
            displayUserData(session);

            // Set the validation message for adding a user to the session
            session.setAttribute("userEditMessage", "The user was updated");

        } else {
            session.setAttribute("userEditMessage", validationMessage);
            displayUserData(session);
        }

        //Create the url
        String url = "editUser.jsp";

        // Redirect to JSP page
        response.sendRedirect(url);

    }

    /**
     * Gets user data.
     *
     * @param session    the session
     * @param genericDao the generic dao
     */
    public void getUserData(HttpSession session, GenericDao genericDao) {

        // Retrieve the ID from the session
        Integer userId = (Integer)session.getAttribute("userID");

        // Get the user data
        user = (User)genericDao.getById(userId);

    }

    /**
     * Display user data.
     *
     * @param session the session
     */
    public void displayUserData(HttpSession session) {

        session.setAttribute("userData", user);

    }

    /**
     * The validateUserData method will validate each of the fields on the form and return a message
     * to the calling method with any invalid responses.
     *
     * @param request the request
     * @return a validation message
     */
    public String validateUserData(HttpServletRequest request) {

        // Define local variables
        String validationMessage = "";

        // Validate the first name
        if (request.getParameter("firstName") == null
                || request.getParameter("firstName").trim() == "") {
            validationMessage += "The first name must be entered and not be all spaces<br />";
        }

        // Validate the last name
        if (request.getParameter("lastName") == null
                || request.getParameter("lastName") == "") {
            validationMessage += "The last name must be entered and not be all spaces<br />";
        }

        // Validate the address 1
        if (request.getParameter("address1") == null
                || request.getParameter("address1") == "") {
            validationMessage += "The first address must be entered and not be all spaces<br />";
        }

        // Validate the city
        if (request.getParameter("city") == null
                || request.getParameter("city") == "") {
            validationMessage += "The city must be entered and not be all spaces<br />";
        }

        // Validate the state
        if (request.getParameter("state") == null
                || request.getParameter("state") == "") {
            validationMessage += "The state must be entered and not be all spaces<br />";
        }

        // Validate the zip code
        String zipCodeValidationMessage = "";
        if (request.getParameter(zipCode) == null
                || request.getParameter(zipCode) == "") {
            validationMessage += "The zip code must be entered and not be all spaces<br />";
        } else {
            zipCodeValidationMessage += validateZipCode(request.getParameter(zipCode));
            if (!zipCodeValidationMessage.equals("")) {
                validationMessage += zipCodeValidationMessage;
            }
        }

        // Validate the phone number
        if (request.getParameter(phone) == null
                || request.getParameter(phone) == ""
                || request.getParameter(phone).length() != 10) {
            validationMessage += "The phone number must be entered , not be all spaces, and 10 digits long<br />";
        }

        // Validate the email
        String emailValidationMessage = "";
        if (request.getParameter(email) == null
                || request.getParameter(email) == "") {
            validationMessage += "The email must be entered and not be all spaces<br />";
        } else {
            emailValidationMessage = validateEmail(request.getParameter(email));
            if (emailValidationMessage.equals("")) {
                user.setUserEmail(request.getParameter(email));
            } else {
                validationMessage += emailValidationMessage;
            }
        }

        return validationMessage;

    }

    /**
     * Validate zip code string.
     *
     * @param zipCodeValue the zip code
     * @return the validation message
     */
    public String validateZipCode(String zipCodeValue) {

        // Create local variables
        String validationMessage = "";

        try {

            // Use GeoNames to validate the zip code
            String url = "http://api.geonames.org/postalCodeSearchJSON";
            String parameters = "?maxRows=1&username=celtic68&country=US&postalcode=" + zipCodeValue;
            URL fullUrl = new URL(url + parameters);

            HttpURLConnection conn = (HttpURLConnection) fullUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode());
            } else {
                String inline = "";
                Scanner sc = new Scanner(fullUrl.openStream());
                while(sc.hasNext())
                {
                    inline += sc.nextLine();
                }
                sc.close();
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(inline);
                JSONArray jsonArray = (JSONArray) json.get("postalCodes");
                if (jsonArray.isEmpty()) {
                    validationMessage = "You have entered an invalid US zip code<br >";
                }
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            logger.error("The URL to validate the zip code is not formatted correctly" + e);
        } catch (IOException e) {
            logger.error("An IO error occurred while validating the zip code" + e);
        } catch (RuntimeException e) {
            logger.error("A Run Time Error occurred while validating the zip code" + e);
        } catch (ParseException e) {
            logger.error("A parsing error occurred while validating the zip code" + e);
        }

        return validationMessage;

    }

    /**
     * Validate email string.
     *
     * @param email the email
     * @return the string
     */
    public String validateEmail(String email) {

        String validationMessage = "";

        // TODO Move the URIs to a properties file and redo the code for zip code validation
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("http://3.132.40.97:8080/GroupProject/thinkingOfSkywalker/validateEmails/" + email);
            Response response = target.request(MediaType.TEXT_PLAIN).get();
            if (response.getStatus() != 200) {
                throw new Exception("Email Service is unavailable " + response.getStatus());
            }

            Boolean emailValidity = Boolean.valueOf(response.readEntity(String.class));
            if (!emailValidity) {
                validationMessage = "You have entered an invalid email address<br >";
            }
        } catch (Exception exception) {
            logger.error("An error occurred while attempting to validate the email - " + exception);
        }

        return validationMessage;

    }

    /**
     * Update user data with the user data from the form
     *
     * @param request the request
     */
    public void updateUser(HttpServletRequest request) {

        user.setUserFirstName(request.getParameter("firstName"));
        user.setUserLastName(request.getParameter("lastName"));
        user.setUserAddress1(request.getParameter("address1"));
        user.setUserCity(request.getParameter("city"));
        user.setUserState(request.getParameter("state"));
        user.setUserZip(request.getParameter(zipCode));

        if (request.getParameter(phone) == null
                || request.getParameter(phone) == ""
                || request.getParameter(phone).length() != 10) {
            user.setUserPhone(0);
        } else {
            user.setUserPhone(Long.parseLong(request.getParameter(phone)));
        }

        user.setUserEmail(request.getParameter("email"));

    }

}
