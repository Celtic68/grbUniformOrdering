package com.joealexanderIII.controller;

import com.joealexanderIII.dao.GenericDao;
import com.joealexanderIII.model.Role;
import com.joealexanderIII.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

            // Add the user to the database
            insertedId = genericDao.insert(user);

            // Set the validation message for adding a user to the session
            if (insertedId > 0) {
                session.setAttribute("userSignUpMessage", "The user was added to the database");
            } else {
                session.setAttribute("userSignUpMessage", "The user was not added to the database");
            }
        } else {
            session.setAttribute("userSignUpMessage", validationMessage);
        }

        //Create the url
        String url = "/com.joealexanderIII/userSignUp.jsp";

        // Redirect to JSP page
        response.sendRedirect(url);

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
        if (request.getParameter("zipCode") == null
                || request.getParameter("zipCode") == "") {
            validationMessage += "The zip code must be entered and not be all spaces<br />";
        } else {
            validationMessage += validateZipCode(request.getParameter("zipCode"));
            if (validationMessage == "") {
                user.setUserZip(request.getParameter("zipCode"));
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
            if (validationMessage == "") {
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
                || request.getParameter("userPassword") !=
                   request.getParameter("confirmUserPassword")) {
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
                validationMessage = "The zip code is not a valid US zip code";
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            logger.error("The URL to validate the zip code is not formatted correctly" + e);
        } catch (IOException e) {
            logger.error("An IO error occurred while validating the zip code" + e);
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
        User user = (User)genericDao.getByPropertyUniqueEqual("userName", userName);

        if (user.getUserName() == userName) {
            validationMessage = "That user name has already been selected - please choose another";
        }

        return validationMessage;
    }

    /**
     * Encrypt string string.
     *
     * @param passedString the passed string
     * @return the encrypted string
     */
    public String encryptString(String passedString) {

        String encryptedString = "";

        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(passedString.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            logger.error("Wrong Message digest algorithm used - could not encrypt password" + e);
            return encryptedString;
        }

    }

}
