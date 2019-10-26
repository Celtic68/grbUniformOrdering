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
 * The UserSignUp servlet will get the post data from the User Sign Up JSP
 * and add the new user to the database.
 *
 * @author jalexander1
 * @version 1.0
 * @since 10 /12/2019
 */
@WebServlet(
        name = "userSignUp",
        urlPatterns = { "/userSignUp-servlet" }
)

public class UserSignUpServlet extends HttpServlet {

    /**
     * The User.
     */
// Define Instance variables
    User user;
    /**
     * The User role.
     */
    Role userRole;
    private final Logger logger = LogManager.getLogger(this.getClass());

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
        int insertedId;
        GenericDao genericDao;

        logger.debug("Started user sign up");
        // Get a session
        HttpSession session = request.getSession();

        // Validate the user data
        validationMessage = validateUserData(request);

        /* If all the validations passed, add the user to the database. If not,
            send the invalid responses.
        */
        if (validationMessage.length() == 0) {

            // Instantiate a generic DAO
            genericDao = new GenericDao(User.class);

            // Set the date Created field to the current timestamp
            user.setDateCreated(LocalDateTime.now());

            // Add the user to the database
            insertedId = genericDao.insert(user);

            // Set the validation message for adding a user to the session
            if (insertedId > 0) {
                session.setAttribute("userSignUpMessage",
                        "The user was added to the database - click <a href='loginAction'>here</a> to log in");
                session.setAttribute("userID", insertedId);
            } else {
                session.setAttribute("userSignUpMessage", "The user was not added to the database");
            }
        } else {
            session.setAttribute("userSignUpMessage", validationMessage);
            displayEnteredFormData(session, request);
        }

        //Create the url
        String url = "userSignUp.jsp";

        // Redirect to JSP page
        response.sendRedirect(url);

    }

    /**
     * Display entered form data when an error occurs.
     *
     * @param session the session
     * @param request the request
     */
    public void displayEnteredFormData(HttpSession session, HttpServletRequest request) {

        session.setAttribute("firstNameValue", request.getParameter("firstName"));
        session.setAttribute("lastNameValue", request.getParameter("lastName"));
        session.setAttribute("address1Value", request.getParameter("address1"));
        session.setAttribute("address2Value", request.getParameter("address2"));
        session.setAttribute("cityValue", request.getParameter("city"));
        session.setAttribute("stateValue", request.getParameter("state"));
        session.setAttribute("zipCodeValue", request.getParameter("zipCode"));
        session.setAttribute("phoneValue", request.getParameter("phone"));
        session.setAttribute("emailValue", request.getParameter("email"));
        session.setAttribute("userNameValue", request.getParameter("userName"));

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

        // Instantiate a new User and Role
        user = new User();
        userRole = new Role();

        // Validate the first name
        if (request.getParameter("firstName") == null
                || request.getParameter("firstName").trim() == "") {
            validationMessage += "The first name must be entered and not be all spaces<br />";

        } else {
            user.setUserFirstName(request.getParameter("firstName"));
        }

        // Validate the last name
        if (request.getParameter("lastName") == null
                || request.getParameter("lastName") == "") {
            validationMessage += "The last name must be entered and not be all spaces<br />";
        } else {
            user.setUserLastName(request.getParameter("lastName"));
        }

        // Validate the address 1
        if (request.getParameter("address1") == null
                || request.getParameter("address1") == "") {
            validationMessage += "The first address must be entered and not be all spaces<br />";
        } else {
            user.setUserAddress1(request.getParameter("address1"));
        }

        // Validate the city
        if (request.getParameter("city") == null
                || request.getParameter("city") == "") {
            validationMessage += "The city must be entered and not be all spaces<br />";
        } else {
            user.setUserCity(request.getParameter("city"));
        }

        // Validate the state
        if (request.getParameter("state") == null
                || request.getParameter("state") == "") {
            validationMessage += "The state must be entered and not be all spaces<br />";
        } else {
            user.setUserState(request.getParameter("state"));
        }

        // Validate the zip code
        String zipCodeValidationMessage = "";
        if (request.getParameter("zipCode") == null
                || request.getParameter("zipCode") == "") {
            validationMessage += "The zip code must be entered and not be all spaces<br />";
        } else {
            zipCodeValidationMessage += validateZipCode(request.getParameter("zipCode"));
            if (zipCodeValidationMessage.equals("")) {
                user.setUserZip(request.getParameter("zipCode"));
            } else {
                validationMessage += zipCodeValidationMessage;
            }
        }

        // Validate the phone number
        if (request.getParameter("phone") == null
                || request.getParameter("phone") == ""
                || request.getParameter("phone").length() > 10) {
            validationMessage += "The phone number must be entered , not be all spaces, and is 10 characters or less<br />";
        } else {
            user.setUserPhone(Long.parseLong(request.getParameter("phone")));
        }

        // Validate the email
        if (request.getParameter("email") == null
                || request.getParameter("email") == "") {
            validationMessage += "The email must be entered and not be all spaces<br />";
        } else {
            user.setUserEmail(request.getParameter("email"));
        }

        // Validate the user name
        if (request.getParameter("userName") == null
                || request.getParameter("userName") == "") {
            validationMessage += "The userName must be entered and not be all spaces<br />";
        } else {
            validationMessage += checkForUserName(request.getParameter("userName"));
            if (validationMessage.equals("")) {
                user.setUserName(request.getParameter("userName"));
                userRole.setUserName(request.getParameter("userName"));
                userRole.setUserRole("user");
                user.setRole(userRole);
                userRole.setUser(user);
            }
        }

        // Validate the password
        if (request.getParameter("userPassword") == null
                || request.getParameter("userPassword") == ""
                || request.getParameter("confirmUserPassword") == null
                || request.getParameter("confirmUserPassword") == ""
                || !request.getParameter("userPassword").equals(
                   request.getParameter("confirmUserPassword"))) {
            validationMessage += "The password fields must be entered, not be all spaces, and must be equal<br />";
        } else {
            String encryptedPassword = encryptString(request.getParameter("userPassword"));
            if (encryptedPassword != "") {
                user.setUserPassword(encryptedPassword);
            } else {
                validationMessage += "The password field could not be encrypted - please try again later<br />";
            }
        }

        return validationMessage;

    }

    /**
     * Validate zip code string.
     *
     * @param zipCode the zip code
     * @return the validation message
     */
    public String validateZipCode(String zipCode) {

        // Create local variables
        String validationMessage = "";

        try {

            // Use GeoNames to validate the zip code
            String url = "http://api.geonames.org/postalCodeSearchJSON";
            String parameters = "?maxRows=1&username=celtic68&country=US&postalcode=" + zipCode;
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
     * Check for user name string.
     *
     * @param userName the user name
     * @return the validation message
     */
    public String checkForUserName(String userName) {

        // Create local variables
        String validationMessage = "";
        GenericDao genericDao = new GenericDao(User.class);

        // Check to see if the user name exists
        List<User> users = genericDao.getByPropertyListEqual("userName", userName);

        // If the user name exists, throw an error message
        if (!users.isEmpty()) {
            validationMessage = "That user name has already been selected - please choose another<br >";
        }

        return validationMessage;
    }

    /**
     * Encrypt passed string.
     *
     * @param passedString the passed string
     * @return the encrypted string
     */
    public String encryptString(String passedString) {

        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();

        try {
            credentialHandler.setAlgorithm("sha-256");
        } catch (NoSuchAlgorithmException e) {
            logger.error("Unable to encrypt password " + e);
        }
        credentialHandler.setEncoding("UTF-8");
        String hashedPassword = credentialHandler.mutate(passedString);

        return hashedPassword;

    }

}
