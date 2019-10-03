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

On 9/30, I used the week 1 example to add the annotations for one to many and many to one to the User, Player, and 
UniformOrder models. I still need to add the one to one annotations for User to Role, but I need to research more to see 
how to do that for fields that are not the key.

On 10/2, I created a generic Dao and remove the User and Role daos. All of the unit tests for User and Role have been 
changed to use the generic Dao and were all re-ran to success. Next up - get the unit tests created for the Player and
UniformOrder models. Before I got into creating those unit tests, I restructured the User and Role tables / models to
implement the one to one annotations for Hibernate. I took the user name and password from the User table and moved
them to the Role table and replaced them with a foreign key id. I then created two test cases in the RoleDaoTest class
to test that relationship.