# GRB Uniform Ordering
## Weekly Reflection

### Week 1 – 9/1/19 through 9/8/19
#### Tasks Completed:
* Decided on a Project Concept
* Created the Problem Statement
* Documented the User Stories
* Rough Version of Project Plan
* Created the Time Log
* Created the Visual Application Screen Flow Diagram
* Started the Text Application Screen Flow document

I have been thinking about this project for over a year as the process has become unwieldy at the complex.  Enterprise 
Java seemed like the perfect opportunity to implement the project as a whole as it is the first class to really bring 
all the pieces of building an application together. The initial piece that will likely take the most time is laying out 
a project plan for the semester…

I decided to use Balsamiq to do the screen design mockups – it seemed the easiest to get in and use right away without a
lot of figuring out to use it.  It was pretty intuitive.\

As far as services this application might consume, I have not really researched that portion. The application design 
seems straightforward so I will likely need to determine how to meet the project criteria of adding these types of 
services.

#### Potential API / Service ideas:
* Could I add map functionality for the travel day?
* What about closest amenities? Can I do in application adds to such places as Subway, etc?
* Does the uniform ordering place have an API to submit a mass order? Have to find out who they use for uniforms…
* How about captcha?

### Week 2 – 9/9/19 through 9/15/19
#### Tasks Completed:
* Finished the Text Application Screen Flow document
* Created the initial project structure in IntelliJ and got it pushed to GitHub
* Transformed all the documents to markdown language and pushed them all to Github

I started the week by finishing off the text document for the screen flow – this is a really helpful document as it 
provides more of a detailed flow than the visual in my opinion.

I got into Activity 4 in week 2, and it seemed like the perfect time to get all my documents added to the repository.
The readMe, Time Log and Weekly Reflection have all been changed to markdown files and push to the remote repository.
For good measure, I also changed and pushed all the remaining design documents as well and signed up for a final 
presentation slot in week 16.

Paula suggested a website https://www.programmableweb.com to search for APIs.  She also suggested maybe a sports ticker,
or an API that validates a zip code for an address.

### Week 3 – 9/16/19 through 9/22/19
#### Tasks Completed:

* Made changes to Project Plan to push database work back to allow for Hibernate training
* Created the SQL files to create tables and insert data
* Created the tables and populated them with initial data
* Generated an ER Diagram for the database

Long week last week with other classes, so I did not get as far ahead as I had hoped. This week will likely be a EJ
focus week.

I updated the Project Plan to push database stuff later and move some jsp work earlier to allow for us to get into
Hibernate concepts to reduce the amount of project refactoring.

All the database design work and table creation is complete with just some small modifications that will be needed based
on what we do in class for Hibernate. I created the SQL in files to make it easier to drop and recreate them quickly.

### Week 4 – 9/23/19 through 9/29/19
#### Tasks Completed:

* Created the POJOs for User, Player, UniformOrder and Role
* Created the log4j and hibernate properties files
* Set up the unit test directory and added the resource files (hibernate, test database, and sql to clean the database)
* Question answered about hibernate - set up a hibernate config file in the test resources root
* Created the Daos for the User and Role classes
* Set up the test database
* Created all the unit tests for The UserDao and RoleDao classes and ran them all to success with 100% coverage
* Created initial versions of the base jsps and the index page
* Created initial version of the Application StartUp class

Again, trying to get projects done in other classes has taken time.  This week will be all EJ as the other projects are
ahead of schedule and I need to put the petal to the metal for this class. On tap for this week will be to get Hibernate 
completely set up and try to get all the jsps created.

Make sure to ask Paula about the hibernate config file when it comes to running unit tests - I had to change the file
to point to the test_sample database to get the tests to run.

I got underway on 9/25 with adding Hibernate to the project after muddling through the week exercise. I am planning to
get it done 9/26 so I can plow through some jsp work starting 9/27. I ran into an issue with the test database
insertion, but it was due to some blank lines in the file.

The Daos are all set to go and the week 4 exercise has been handed in as part of the project.  All the units tests for
those two classes are also set to go. 9/26 will actually begin jsp work.

On 9/26, I started the creation of the jsps.  I began with some base stuff like the head, header, and footer which will
be re-used.  I also did an initial version of the index page as well as the master CSS file.  Lots more to do here...

I also created an ApplicationStartUp class - right now, the only thing it does is set up a singleton for the 
SessionFactoryProvider and sets it to the session. Not used yet, but as I start creating servlets, it will come in
handy.

On 9/28, I attended the GDG DevFest 2019 conference for my professional development task. It was a wonderful experience
that I look forward to doing again next year. On 9/29, I used all my notes to create my presentation which I will be 
doing this upcoming week in class.

### Week 5 – 9/30/19 through 10/6/19
#### Tasks Completed:

* Added Hibernate one to many and many to one annotations to models
* Created a generic DAO and removed the usage of the User and Role Daos
* Added the one to one annotations for User / Role
* Reworked and performed all unit tests for the User and Role models including the one to one testing.
* Updated GenericDao to accept an Object when doing an unique search to remove redundant code

On 9/30, I used the week 1 example to add the annotations for one to many and many to one to the User, Player, and 
UniformOrder models. I still need to add the one to one annotations for User to Role, but I need to research more to see 
how to do that for fields that are not the key.

On 10/2, I created a generic Dao and remove the User and Role daos. All of the unit tests for User and Role have been 
changed to use the generic Dao and were all re-ran to success. Next up - get the unit tests created for the Player and
UniformOrder models. Before I got into creating those unit tests, I restructured the User and Role tables / models to
implement the one to one annotations for Hibernate. I took the user name and password from the User table and moved
them to the Role table and replaced them with a foreign key id. I then created two test cases in the RoleDaoTest class
to test that relationship.

After discussion with Paula, I need to rework the one to one since user name has to be on both tables. I was able to
get this done and tested on 10/3. There was some feedback from Paula with an issue created for it - I need to make sure
that when a delete of a user happens, the role is deleted as well. Also, I can change the Generic Dao when doing a
getPropertyEqual to accept an object so that a string or number can be passed. These changes were implemented on 10/3.

I then moved on to creating unit tests for the Player model. I ran into an issue when trying to do a save / update where
the user id column was listed twice in the SQL. After not having much luck via searching, I touched base with Paula and
she pointed out that I was defining the user ID in my model and it should not be. I made the suggested change and the 
test ran to completion. I then recreated the error and posted it to Slack to help someone else running into that issue.
I should finish the Player and UniformOrder unit tests this weekend.

On 10/4, I finished creating all the unit tests for the Player model and then re-ran all the tests and all the tests
with coverage - everything passed and coverage was 100%. I pushed the changes and moved on to the UniformOrder model.
On 10/5 and 10/6, I created and finalized all of the unit tests for the UniformOrder model and ran all unit tests to 
success. At this point, I believe all the unit tests are created and have all run to success with 100% coverage.

### Week 6 – 10/7/19 through 10/13/19
#### Tasks Completed:

* Week 1 exercise pushed to AWS
* User Sign Up jsp created and finished
* User Edit jsp created
* Add Player jsp created
* SQL generation files updated to create the age group table

A suggestion made for my project - instead of asking the user what jersey number they want, show a list of available
jersey numbers to pick from. APIs I will use are the email API and the weather API (Geonames).

The User Sign Up jsp is created - just need a little tweaking with adding the legend instead of using a header. The
changes were made and the sign up page is set to go - on to the user edit screen. The user edit screen went pretty
quick as I was able to use the sign up page as a model - it just needs the user data now to pre-populate the fields
which will be sent by a servlet. Next up is the Add player jsp... and it is now set to go, too. I also updated the sql 
generation files to create the age group table.

### Week 7 – 10/14/19 through 10/20/19
#### Tasks Completed:

* User Sign up jsp and servlet are up and running - just need to hash the password and do some formatting
* Login and Logout functionality through Tomcat are up and running locally
* Navigation menus have been reworked to use Bootstrap 4 formatting
* Index page has now implemented the proposed design
* Hashing functionality now works for the password in the Login and Sign Up process
* User (and their roles) are now being added to the database
* Improved the customer experience on the Sign Up page by saving entered data when an error occurs

I started a new internship this week, so my work on the project took a hit for the first part of this week. I still need
to get the user signup servlet working. After that, the focus will be on getting the login functionality up and running
and get the project pushed to AWS for the first time.

On 10/16, I finished up getting the user sign up jsp and servlet functional where validation and the API call are 
working as intended. I still need to finish up the encryption logic for the password in that chain.

On 10/19, I got the login functionality going by creating the login and login error jsps and the logout servlet. I also
updated the web xml file for security and added the context xml file. Next up is to watch the video created to walk 
through Paula's example for landing on the index page with no login. Before I watched the video, I wanted to be sure the 
login process was working as it should be and it is - YAY! I finished watching the video explaining the login button, so
next up is getting the home page / login functionality up and running. Once this is set, I will deploy to AWS.

I now have the index page, login, and logout functionality all working. I also redid the navigation menus to take 
advantage of Bootstrap 4 formatting and tested through the site for navigation. The next piece will be to get sha-1
hashing set up for the passwords and then deploy the current state of the application to AWS. I also need to set up
security on the user and admin pages to force the user to the login screen.

On 10/20, I tested through the user sign up process and removed several bugs - this process now works as intended. I
also got the hashing functionality added for the password for Login and User Sign up. To improve the customer experience,
I implemented saving entered data when the sign up process encounters an error server side - if I can, I would like to
implement front end validation as well as time allows. I secured the Add Player and Edit User pages for users and admins
 as those are the pages I have completed - I will add the pages as I create them from here on out. Next up will be to 
deploy my indie project in its current state to AWS. 

### Week 8 – 10/21/19 through 10/27/19
#### Tasks Completed:

* Database and tables created on the AWS EC2 instance
* Added the static table data
* Deployed the initial version of the project to AWS and tested the authentication functionality for correctness
* Created the Edit User flow, tested it locally, and pushed it to AWS
* Created the Add / Edit Player jsp and got player data showing as expected
* Fixed bugs found in the User Sign Up and Edit User flows
* Entire Add / Edit Player flow built and tested locally
* Project built and deployed to AWS in preparation for checkpoint 3

On 10/22, I got my database and tables for the indie project created on my AWS instance. At the same time, I inserted
the data into the tables that support sizes, etc. Once that was done, I plunged ahead and set up the instance for my
indie project, bundled up the war file, and deployed it to AWS. I then tested through the sign up and login processes to 
ensure the authentication process worked. As of the end of the day on 10/22, my project is up and running on EC2. The 
only piece left for checkpoint 3 is to get data showing on one of the jsps.

OK, it's 10/26 and I spent a good chunk of the day working on some servlet and jsp functionality - it was a productive 
day. The Edit User flow is now built. I tested it locally and then pushed it up to AWS. After continuing to do some
testing, I noticed a couple bugs in it as well as the User Sign Up flow so I fixed those and re-deployed. I also got
the Add / Edit Player jsp and servlet started - the jsp is handling both the no player found and players found
correctly. Next up is to work on the Add Player and Edit Player pages.
 
I was back at it early on 10/27 and had another productive day. The entire Add / Edit Player flow is built and has been 
tested locally. There will be some refactoring needed - I will be looking hard at the form field validation and the 
add / edit jsps and servlets once the first version of the project is built and running. That said, this is the first
time I have felt like I was in a good position for getting the project done for the end of the semester. I also got the
package deployed to AWS and tested to make sure it worked there as well.

### Week 9 – 10/28/19 through 11/3/19
#### Tasks Completed:

* Joined a team - Team ThinkingOfSkywalker - for the team project
* Met and discussed concept and got approval from instructor
* Created the service and tested the components to ensure they are returning the correct responses based on the passed criteria

This week has been all about the team project. We decided to create a service that could be used by other classmates as 
part of their individual projects. Our service performs two different functions - it will accept an email and return a 
true or false response denoting if the email is valid and it will also accept a table name, column name, and value and 
return a response denoting if the value exists in that table or not. We created our problem statement, proposed solution
and created a repository. We then divided up the work - I was responsible for created the read me file as well as the 
application and service classes. I completed all those classes and tested the service locally (as well as running the 
unit tests created by my teammates for their classes) to ensure the proper responses are being received. Next up, we 
will be determining how to package up a jar file and deploying it to one of our AWS instances and implementing it to
show it working.

### Week 10 – 11/04/19 through 11/10/19
#### Tasks Completed

* Team Project completed and ready for presentation
* Week 10 Git Branching activity done

Again, this week was about the team project. We all completed our individual pieces and then met in class on Wednesday 
and cleaned up the code, finalized the documentation, and talked about how we would break down the presentation in two 
weeks.  It was also used to complete the week 9 activity for each of our team members. I also got the Git Branching
activity done on Wednesday. However, the flu bug decided to make a visit Thursday, so here we are on Sunday trying to 
get some more accomplished.  :(

### Week 11 – 11/11/19 through 11/17/19
#### Tasks Completed

* Team Project refactored for suggested changes by instructor
* Week 11 multithreading exercise completed

I was able to get the multithreading exercise complete and ready to go and showed it to Paula for check-off. In class, 
Alex and I refactored our team project code to implement the suggested changes from Paula. Next, I need to redo the API
calls in my individual project to get them ready for presentation next week.

### Week 12– 11/18/19 through 11/25/19
#### Tasks Completed

* Team Project presentation completed

We presented our team project to the class this week, and I decided to focus on one class at a time to get all the 
necessary work done class by class which lead to no progress on my indie project this week.

### Week 13 – 11/26/19 through 12/1/19
#### Tasks Completed

* All other classes project work is done
* 

It doesn't progress my indie project at all, but I completed all project work for all my other classes so the remaining
three weeks will be solely focused on my indie project.

### Week 14 – 12/2/19 through 12/8/19
#### Tasks Completed

* Met with Alex and performed peer review
* Added an issue to Alex's github

I met with Alex to walk through his application and code - he has really done a very good job with his project. I also 
got his peer review posted as an issue to his repo.

### Week 15 – 12/9/19 through 12/15/19
#### Tasks Completed

* Player Selection for Uniform Ordering is running locally
* 

This is it - the last push. I will not get fully done as I had to prioritize work, but the goal is to try to get as much
functionality as possible in this last week and do some clean up. First off, I now have the Player Selection piece of 
Uniform Ordering up and running locally. I plan to get the update piece working before I deploy to AWS.