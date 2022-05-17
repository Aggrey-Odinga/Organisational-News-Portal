SET MODE PostgreSQL;

CREATE DATABASE news_portal;

\c news_portal

CREATE TABLE IF NOT EXISTS users(
id serial PRIMARY KEY, name VARCHAR, department VARCHAR, role VARCHAR);
CREATE TABLE IF NOT EXISTS department(
id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employees VARCHAR);
CREATE TABLE IF NOT EXISTS news(
id serial PRIMARY KEY, name VARCHAR, author VARCHAR, description VARCHAR);

CREATE TABLE IF NOT EXISTS department_users(id serial PRIMARY KEY, userId INTEGER, departmentId INTEGER);
