package com.joealexanderIII.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import com.joealexanderIII.dao.SessionFactoryProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *  The Application Startup servlet will be run when the application is first started to
 *  load any general properties and create a SessionFactory instance.
 *
 * @author    jalexander1
 * @version   1.0
 * @since     09/26/2019
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/grb-uniform-startup" },
        loadOnStartup = 1
)
public class ApplicationStartUp extends HttpServlet {

    // Define instance constants
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Override the init method to create a SessionFactory instance and set it to the application context
     *
     *@exception ServletException for servlet failures
     */
    public void init() throws ServletException {

        try {
            // Instantiate a SessionFactory object
            SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

            // Set the EmployeeDirectory object to the application context
            this.getServletConfig().getServletContext()
                    .setAttribute("sessionFactory", sessionFactory);

        } catch (Exception exception) {
            logger.error("There was a problem. " + exception);
        }

    }

}
