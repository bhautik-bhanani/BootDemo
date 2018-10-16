# BootDemo
Spring Boot application

Spring Boot application for REST APIs
  - Database tables:
      - Book
      - Category

Application continas Docker and Jenkins file on root folder. To build and execute this application using Jenkins and Docker container, follow below Steps:

Jenkins:
  - Install Jenkins on local machine or cloud platform.
  - Follow this link to create "BootDemo" project on Jenkins: https://www.tutorialspoint.com/jenkins/jenkins_maven_setup.htm
  - In configuration, in Post-command section add following command to run your application from Docker container.
   
          sudo docker build -t boot-demo-image:${BUILD_NUMBER} $WORKSPACE
          sudo docker run -p 5000:5000 --name boot-demo-container:0.1 -- link boot-mysql-container:mysql -d boot-demo-image:${BUILD_NUMBER}
          
  - Save the project and create a build.

Docker:
  - Install Docker on local machine or cloud platform.
  - Install MySQL on one Docker container and give name "boot-mysql-container" from following link: https://hub.docker.com/r/mysql/mysql-server/
  - Jenkins will run given command after build gets successful and create one image and container for the application. Also by "--link" will link MySQL container in Docker with Spring Boot application on other container. 
  - To run application, use IP address or for local machine use "localhost" followed by port number "5000" as per mentioned into command.

Database queries to create tables:
Book ==> 
      DROP TABLE IF EXISTS book;
      CREATE TABLE IF NOT EXISTS book ( 
                    bookId int(11) NOT NULL AUTO_INCREMENT,
                    bookTitle varchar(100) NOT NULL,
                    categoryId int(11) NOT NULL, PRIMARY KEY (bookId) )
      ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
      
Category ==>
      DROP TABLE IF EXISTS category;
      CREATE TABLE IF NOT EXISTS category (
                    categoryId int(11) NOT NULL AUTO_INCREMENT,
                    categoryName varchar(50) NOT NULL,
                    PRIMARY KEY (categoryId) )
      ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
