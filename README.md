# ORGANISATIONAL NEWS PORTAL

## Project Description
   
   The News Portal App provides a variety of news articles for all employees as well as customized news stories for different departments inside the firm.
   
   For searching and retrieving scoped news and information, the application uses a REST API.
   


## Author's Information

<p>Authors name: Aggrey Odinga.</p>

Github link to my site [Aggrey Odinga](https://github.com/Aggrey-Odinga).

## Project Set Up Instructions

 To set up this project:

<p> Clone the repository<p>
<p> Navigate into the news-portal directory - cd news-portal <p>
<p> Run gradle build to build the project. </p>

## Database Set Up Instructions

   - To set up the database in a new project:
   Create a create.sql file in the root project and add the following data:
   
  - CREATE DATABASE news_portal;
   -\c news_portal
  - CREATE TABLE users(id serial PRIMARY KEY, name VARCHAR, department VARCHAR, role VARCHAR);
  - CREATE TABLE departments(id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employees VARCHAR);
  - CREATE TABLE news_articles(id serial PRIMARY KEY, name VARCHAR, author VARCHAR, description VARCHAR, time TIMESTAMP);
  - CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;`
  

## Technologies Used:
   
   - Java.
   - Postgres.
   - Spark.
   
## Contact Information
   
   - Email me at: aggreyodinga@gmail.com
   
   ## [License](https://github.com/Aggrey-Odinga/Organisational-News-Portal/blob/master/License)