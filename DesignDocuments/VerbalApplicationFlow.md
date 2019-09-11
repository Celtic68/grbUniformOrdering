# GRB Uniform Ordering

## Verbal Application Flow

### User Sign Up
1.	User selects Sign Up from the toolbar on the initial Index page
1.  User enters all pertinent personal information, captcha and clicks submit
1.  Sign up request goes to the servlet
1.  Servlet creates a new User and adds it to the user table.
1.  Servlet responds with a success message and user is directed to the Index page

### User Sign In
1.	User selects Login from the toolbar on the initial Index page
1.  User enters their username and password and click submit
1.  If the User is authenticated, they are forwarded to the Home page for their role (User or Admin)
1.  If the User fails authentication, an error message is displayed.

### Edit User
1.	User selects Edit User and request is sent to the servlet
1.  Servlet retrieves user data and forwards to the Edit User jsp which shows their personal information in an editable 
form
1.  User updates any pertinent personal information and click submit which sends a request to the servlet
1.  Servlet updates the user table
1.  Servlet responds with a success message and user is redirected to the Edit User page

### Add / Edit Player
1.	User selects Add / Edit Player and request is sent to the servlet
1.  Servlet gets current players for the User and forwards to the Add / Edit Player jsp which shows a list of the 
players with the edit and delete link as well as a button to add a new player
1.  If the user clicks the edit link, request is sent to the servlet. Servlet retrieves player data and forwards to the
Edit player jsp which shows their personal information in an editable form. User updates any pertinent personal 
information and click submit which sends a request to the servlet. Servlet updates the player table. 
Servlet responds with a success message and user is redirected to the Add / Edit Player page
1.  If the user clicks the delete link, request is sent to the servlet. Servlet retrieves player data and forwards to 
the Delete player jsp which shows their personal information and a confirm button. If confirmed, click submit which 
sends a request to the servlet. Servlet updates the player table. Servlet responds with a success message and user is 
redirected to the Add / Edit Player page.
1.  If the user clicks the add player button, user is forwarded to the Add Player jsp which gives the user a form to 
enter the player data. User enters player data and clicks submit which sends a request to the servlet. Servlet updates 
the player table. Servlet responds with a success message and user is redirected to the Add / Edit Player page

### Order Uniform
1.	User selects Order Uniform from the toolbar and a request is sent to the servlet
1.  Servlet gets the current players and forwards to the Order Uniform Player list jsp. 
1.  User selects a player link to order a uniform for and a request is sent to the servlet
1.  Servlet checks for existing order for that player.  If order exists, data is forwarded to Order Uniform jsp
1.  Order Uniform jsp displays a form. If existing order, data is prepopulated; otherwise, form is defaulted.
1.  User sets uniform order and clicks submit and request is sent to servlet
1.  Servlet updates the uniform table
1.  Servlet responds with a success message and user is redirected to the Order Uniform player list.

### Admin Add Admin
1.	User selects Add Admin and is forwarded to the jsp
1.  Add Admin has a search form that sends search criteria to a servlet
1.  Servlet gets a list of users and forwards to a jsp
1.  Admin selects a link to a user and forwarded to a confirmation jsp
1.  Admin clicks confirm and a request is sent to the servlet
1.  Servlet updates the User table
1.  Servlet responds with a success message and admin is redirected to the Add Admin jsp.

### Admin Add / Edit Player, Admin Order Uniform
1.  Works the same as the User screens except there is a search function which will send a request to a servlet to 
retrieve the pertinent data and forward to a jsp
