===================================================================================================================
Upper Hand -- Coding Challenge
Implementation of RESTful web service that performs Event Schedule operations
Author  : Ashok Choudhary Jasaram
===================================================================================================================

As instructed in the coding challenge I have successfully created a Spring Restful Webservice which will perform the required the CRUD operations, thereby following the guidelines in the requirement file  provided.

The main purpose that I have chosen Spring is that, the application in schedule.zip is a Microservice. Using the latest and greatest technology available, I have created a RESTful Spring. Here i have used MySQL Database. However, the best part of the application is that, it is possible to run this application even on any other Databases, namely SQL Server, MySQL, H2 database which is an in-memory database, etc., just by providing the database name and other login credentials in the config file and we are good to go. 

The app has been designed keeping everything in mind. Thinking about automated testing, o yeah it has been developed keeping that in mind and testing Spring MVC with Mockito can be integrated into this project like a breeze.

I have created the app schedule.zip, which has same exposed methods to achieve the CRUD functionality but in this method, I have followed Spring MVC standard creating different layers like Service layer, Data Access Layer and so on.
===================================================================================================================
schedule
SRC : Application.java
      ServletInitializer.java
      ScheduleController.java
      ScheduleServiceImpl.java
      ScheduleRepositoryImpl.java
      EnrollValidator.java
      InstructorEntity.java
      ScheduleEntity.java
      BadRequestException.java
      NotFoundException.java
===================================================================================================================
Considering all the scenarios mentioned properly in the requirements doc and the available technology stacks, I have built this app.